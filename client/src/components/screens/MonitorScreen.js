import React from 'react';
import {Modal, Card, Row, Col, Table, Button, InputNumber, Tag} from 'antd';
import axios from 'axios';

const event_columns = [
    {
        title: 'ID',
        dataIndex: 'id',
        ellipsis: true,
        width: '10%'
    },
    {
        title: 'User ID',
        dataIndex: 'user_id',
        width: '15%',
        render: id => (
            <b>
                {id}
            </b>
        )
    },
    {
        title: 'Session ID',
        dataIndex: 'session_id',
        width: '15%',
        render: id => (
            <b>
                {id}
            </b>
        )
    },
    {
        title: 'URL',
        dataIndex: 'url',
        width: '60%',
        render: id => (
            <span style={{fontSize: 11}}>
                {id}
            </span>
        )
    }
];

const action_columns = [
    {
        title: 'Name',
        dataIndex: 'rule.name',
        width: '25%',
        render: name => (
            <b>
                {name}
            </b>
        )
    },
    {
        title: 'Pattern',
        dataIndex: 'rule.pattern',
        width: '60%'
    },
    {
        title: 'Action',
        dataIndex: 'rule.action',
        width: '15%',
        render: action => {
            let color = 'geekblue';
            if (action === 'ALERT') {
                color = 'cyan';
            } else if (action === 'EMAIL') {
                color = 'blue';
            } else if (action === 'SMS') {
                color = 'gold';
            }
            return (
                <Tag color={color}>
                    {action.toUpperCase()}
                </Tag>
            );
        }
    }
];

class MonitorScreen extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            isStreaming: false,
            frequency: 100,
            eventData: [],
            actionData: [],
            controlButtonLoading: false,
            resetButtonLoading: false
        }
    }

    componentDidMount() {
        this.getEventStreamState();
        this.connectSocket();
    }

    connectSocket = () => {
        let keyCounter = 0;
        let self = this;
        let webSocket = new WebSocket("ws://localhost:4568/socket/");
        webSocket.onopen = function () {
            console.log("Connection is opened.");
        };

        webSocket.onmessage = function (message) {
            const data = JSON.parse(message.data);
            const event = JSON.parse(data["message"]);
            event["key"] = ++keyCounter;

            let list = [event];
            if (data["topic"] === "Events") {
                list = list.concat(self.state.eventData);
                self.setState(_ => {
                    return {eventData: list.slice(0, 100)};
                });
            } else if (data["topic"] === "Actions") {
                list = list.concat(self.state.actionData);
                self.setState(_ => {
                    return {actionData: list.slice(0, 100)};
                });
                console.log(event);
            }
        };
        webSocket.onclose = function () {
            console.log("Connection is closed.");
        };
    };

    getEventStreamState = () => {
        let self = this;
        self.setState({controlButtonLoading: true, resetButtonLoading: true});
        axios.get('http://localhost:4567/state')
            .then(function (response) {
                if (response.data.status === "SUCCESS") {
                    self.setState({isStreaming: response.data.data.running});
                }
            })
            .catch(function (error) {
                console.log(error);
            }).finally(function () {
            self.setState({controlButtonLoading: false, resetButtonLoading: false});
        });
    };

    handleEventStream = () => {
        if (this.state.isStreaming) {
            this.pauseEventStream();
        } else {
            this.startEventStream();
        }
    };

    startEventStream = () => {
        let self = this;
        self.setState({controlButtonLoading: true});
        axios.post('http://localhost:4567/start', {
            frequency: this.state.frequency
        })
            .then(function (response) {
                if (response.data.status === "SUCCESS") {
                    self.setState({isStreaming: true});
                }
            })
            .catch(function (error) {
                console.log(error);
            }).finally(function () {
            self.setState({controlButtonLoading: false});
        });
    };

    pauseEventStream = () => {
        let self = this;
        self.setState({controlButtonLoading: true});
        axios.post('http://localhost:4567/pause')
            .then(function (response) {
                if (response.data.status === "SUCCESS") {
                    self.setState({isStreaming: false});
                }
            })
            .catch(function (error) {
                console.log(error);
            }).finally(function () {
            self.setState({controlButtonLoading: false});
        });
    };

    resetEventStream = () => {
        let self = this;
        self.setState({resetButtonLoading: true});
        axios.post('http://localhost:4567/stop')
            .then(function (response) {
                if (response.data.status === "SUCCESS") {
                    self.setState({isStreaming: false});
                }
            })
            .catch(function (error) {
                console.log(error);
            }).finally(function () {
            self.setState({resetButtonLoading: false});
        });
    };

    onChange = (value) => {
        this.setState({frequency: value});
    };

    render() {
        return (
            <div>
                <Row type="flex" justify="space-between" gutter={[16, 16]}>
                    <Col span={12}>
                        <Row style={{marginBottom: 16}}>
                            <Card title='Data Source' style={{height: 132}}>
                                <Row type="flex" justify="space-between">
                                    <Col>
                                        <span style={{marginRight: 24}}>Frequency:</span>
                                        <InputNumber min={0} max={1000} step={100} onChange={this.onChange}
                                                     value={this.state.frequency}/>
                                    </Col>
                                    <Col>
                                        <Button loading={this.state.controlButtonLoading} style={{marginRight: 12}}
                                                type={this.state.isStreaming ? 'default' : 'primary'}
                                                onClick={this.handleEventStream}>
                                            {this.state.isStreaming ? 'Pause Event Stream' : 'Start Event Stream'}
                                        </Button>
                                        <Button loading={this.state.resetButtonLoading} type='danger'
                                                onClick={this.resetEventStream}>Reset Event Stream</Button>
                                    </Col>
                                </Row>
                            </Card>
                        </Row>
                        <Row>
                            <Card title='Event Stream' bodyStyle={{padding: 0}}>
                                <Table style={{backgroundColor: '#fff'}} scroll={{y: 'calc(70vh - 174px)'}}
                                       columns={event_columns}
                                       dataSource={this.state.eventData} pagination={false}/>
                            </Card>
                        </Row>
                    </Col>
                    <Col span={12}>
                        <Card title='Captured Pattern Stream' bodyStyle={{padding: 0}}>
                            <Table style={{backgroundColor: '#fff'}} scroll={{y: 'calc(67vh - 2px)'}}
                                   columns={action_columns}
                                   dataSource={this.state.actionData} pagination={false}
                                   onRow={(record, rowIndex) => {

                                       let color = 'geekblue';
                                       if (record["rule"].action === 'ALERT') {
                                           color = 'cyan';
                                       } else if (record["rule"].action === 'EMAIL') {
                                           color = 'blue';
                                       } else if (record["rule"].action === 'SMS') {
                                           color = 'gold';
                                       }

                                       let content = [];
                                       Object.keys(record["match"]).forEach(function (key) {
                                           let data = record["match"][key];

                                           content.push(
                                               <Card key={content.length - 1} title={key} style={{marginTop: 24}} bodyStyle={{padding: 0}}>
                                                   <Table showHeader={false} columns={event_columns} dataSource={data} pagination={false}/>
                                               </Card>
                                           );
                                       });

                                       return {
                                           onClick: event => {
                                               Modal.info({
                                                   width: '70%',
                                                   title: (
                                                       <div>
                                                           <span style={{verticalAlign: 'middle'}}>
                                                               {record["rule"].name}
                                                           </span>
                                                           <Tag style={{marginLeft: 12}} color={color}>
                                                               {record["rule"].action.toUpperCase()}
                                                           </Tag>
                                                       </div>
                                                   ),
                                                   content: (
                                                       <div>
                                                           <span style={{fontSize: 24}}>
                                                               {record["rule"].pattern}
                                                           </span>
                                                           {content}
                                                       </div>
                                                   ),
                                                   onOk() {
                                                   },
                                               });
                                           },
                                           onDoubleClick: event => {
                                           },
                                           onContextMenu: event => {
                                           },
                                           onMouseEnter: event => {
                                           },
                                           onMouseLeave: event => {
                                           },
                                       };
                                   }}/>
                        </Card>
                    </Col>
                </Row>
            </div>
        );
    }
}

export {MonitorScreen};
