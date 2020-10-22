import React, { Component } from 'react';

//components
import Task from './Task';

export default class Tasks extends Component {
    render() {
        return (
            <div>
                <table className="table ">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Descripción</th>
                            <th>Fecha Creación</th>
                            <th>Vigente</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        {this.props.tasks.map(task => 
                            <Task key={task.id}
                                task={task}
                                selectTask={this.props.selectTask}
                                togglerModalDelete={this.props.togglerModalDelete}
                                togglerModalForm={this.props.togglerModalForm}/>
                        )}       
                    </tbody>
                </table>
            </div>
        )
    }
}
