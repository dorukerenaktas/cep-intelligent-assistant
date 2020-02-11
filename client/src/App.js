import React from 'react';
import {BrowserRouter as Router, Switch, Route, Redirect, Link} from "react-router-dom";
import 'antd/dist/antd.css';

import {Layout, Menu} from 'antd';
import {RuleScreen} from "./components/screens/RuleScreen";
import {MonitorScreen} from "./components/screens/MonitorScreen";

const {Header, Content} = Layout;

function App() {
    return (
        <Router>
            <Layout className="layout" style={{flex: 1, width: '100vw', height: '100vh'}}>
                <Header>
                    <Menu
                        theme="dark"
                        mode="horizontal"
                        defaultSelectedKeys={['2']}
                        style={{lineHeight: '64px'}}
                    >
                        <Menu.Item key="1">
                            <Link to="/create">Rules</Link>
                        </Menu.Item>
                        <Menu.Item key="2">
                            <Link to="/monitor">Monitor</Link>
                        </Menu.Item>
                    </Menu>
                </Header>
                <Content style={{padding: 50}}>

                    <Switch>
                        <Route path="/create">
                            <RuleScreen/>
                        </Route>
                        <Route path="/monitor">
                            <MonitorScreen/>
                        </Route>
                        <Route path="/">
                            <Redirect to="/monitor"/>
                        </Route>
                    </Switch>

                </Content>
            </Layout>
        </Router>
    );
}

export default App;
