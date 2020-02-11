import React from 'react';
import { Modal, Form, Input, Typography } from 'antd';

const { Title } = Typography;

const CreateRuleModal = Form.create({ name: 'form_in_modal' })(
    class extends React.Component {
        render() {
            const { visible, onCancel, onCreate, form } = this.props;
            const { getFieldDecorator } = form;
            return (
                <Modal
                    visible={visible}
                    title="Create New Rule"
                    okText="Create"
                    onCancel={onCancel}
                    onOk={onCreate}
                >
                    <Form layout="vertical">
                        <Title level={3}>Source</Title>
                        <Form.Item label="Broker">
                            {getFieldDecorator('source_broker', {
                                initialValue: "kafka:9093",
                                rules: [{ required: true, message: 'Please fill the input!' }],
                            })(<Input />)}
                        </Form.Item>
                        <Form.Item label="Topic">
                            {getFieldDecorator('source_topic', {
                                initialValue: "Events",
                                rules: [{ required: true, message: 'Please fill the input!' }],
                            })(<Input />)}
                        </Form.Item>

                        <Title level={3}>Sink</Title>
                        <Form.Item label="Broker">
                            {getFieldDecorator('sink_broker', {
                                initialValue: "kafka:9093",
                                rules: [{ required: true, message: 'Please fill the input!' }],
                            })(<Input />)}
                        </Form.Item>
                        <Form.Item label="Topic">
                            {getFieldDecorator('sink_topic', {
                                initialValue: "Actions",
                                rules: [{ required: true, message: 'Please fill the input!' }],
                            })(<Input />)}
                        </Form.Item>

                        <Title level={3}>Rule</Title>
                        <Form.Item label="Name">
                            {getFieldDecorator('name', {
                                initialValue: "Test Rule",
                                rules: [{ required: true, message: 'Please fill the input!' }],
                            })(<Input />)}
                        </Form.Item>
                        <Form.Item label="Action">
                            {getFieldDecorator('action', {
                                initialValue: "ALERT",
                                rules: [{ required: true, message: 'Please fill the input!' }],
                            })(<Input />)}
                        </Form.Item>
                        <Form.Item label="Pattern">
                            {getFieldDecorator('pattern', {
                                initialValue: "A(user_id='102111')",
                                rules: [{ required: true, message: 'Please fill the input!' }],
                            })(<Input.TextArea rows={4} />)}
                        </Form.Item>
                    </Form>
                </Modal>
            );
        }
    },
);

export {CreateRuleModal}
