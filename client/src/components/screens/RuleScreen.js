import React from 'react';
import {Tag, Button, Table, Card} from 'antd';
import {CreateRuleModal} from "./CreateRuleModal";
import axios from "axios";

const columns = [
    {
        title: 'ID',
        dataIndex: 'id',
        key: 'id',
        ellipsis: true,
        width: '15%'
    },
    {
        title: 'Name',
        dataIndex: 'name',
        key: 'name',
        width: '15%',
        render: name => (
            <b>
                {name}
            </b>
        )
    },
    {
        title: 'Pattern',
        dataIndex: 'pattern',
        key: 'pattern',
        width: '50%'
    },
    {
        title: 'Action',
        dataIndex: 'action',
        key: 'action',
        width: '10%',
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
    },
    {
        title: 'Status',
        dataIndex: 'status',
        key: 'status',
        width: '10%',
        render: status => {
            let color = 'geekblue';
            if (status === 'FAILED') {
                color = 'red';
            } else if (status === 'CANCELED') {
                color = 'purple';
            }
            return (
                <Tag color={color}>
                    {status.toUpperCase()}
                </Tag>
            );
        }
    },
];

class RuleScreen extends React.Component {
    state = {
        visible: false,
        rules: [],
        buttonLoading: false,
        tableLoading: false
    };

    componentDidMount() {
        this.getRules();
    }

    getRules = () => {
        let self = this;
        this.setState({tableLoading: true});
        axios.get('http://localhost:4568/rules')
            .then(function (response) {
                console.log(response);
                if (response.data.status === "SUCCESS") {
                    self.setState({rules: response.data.data});
                }
            })
            .catch(function (error) {
                console.log(error);
            }).finally(function () {
            self.setState({tableLoading: false});
        });
    };

    showModal = () => {
        this.setState({visible: true});
    };

    handleCancel = () => {
        this.setState({visible: false});
    };

    handleCreate = () => {
        let self = this;
        const {form} = this.formRef.props;
        form.validateFields((err, values) => {
            if (err) {
                return;
            }

            self.setState({buttonLoading: true});
            axios.post('http://localhost:4568/jobs', {
                args: [values["source_broker"], values["source_topic"], values["sink_broker"], values["sink_topic"], values["name"], values["pattern"], values["action"]]
            })
                .then(function (response) {
                    console.log(response);
                    self.getRules();
                })
                .catch(function (error) {
                    console.log(error);
                }).finally(function () {
                self.setState({buttonLoading: false});
            });

            form.resetFields();
            this.setState({visible: false});
        });
    };

    saveFormRef = formRef => {
        this.formRef = formRef;
    };

    render() {
        return (
            <div>
                <Button type="primary" onClick={this.showModal} loading={this.state.buttonLoading}>
                    Create New Rule
                </Button>
                <CreateRuleModal
                    wrappedComponentRef={this.saveFormRef}
                    visible={this.state.visible}
                    onCancel={this.handleCancel}
                    onCreate={this.handleCreate}
                />

                <Card title='Rules' style={{marginTop: 24}} bodyStyle={{padding: 0}}>
                    <Table scroll={{x: 'max-content', y: true}} loading={this.state.tableLoading}
                           columns={columns}
                           dataSource={this.state.rules} pagination={false} rowKey="id"/>
                </Card>
            </div>
        );
    }
}

export {RuleScreen};
