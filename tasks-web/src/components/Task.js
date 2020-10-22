import React, { Component } from 'react';
import Moment from 'moment';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faEdit, faTrashAlt, faCheck, faTimes } from '@fortawesome/free-solid-svg-icons';

export default class Task extends Component {
    render() {
        const {task}=this.props;
        return (
            <tr>
                <td>{task.id}</td>
                <td>{task.description}</td>          
                <td>
                    {Moment(task.dateCreation).format('YYYY-MM-DD')}
                </td>
                <td>
                    <FontAwesomeIcon icon={task.vigente?faCheck:faTimes}/>
                </td>
                <td>
                    <button className="btn btn-primary mr-1"
                        onClick={() => this.props.togglerModalForm(task)}>
                        <FontAwesomeIcon icon={faEdit}/>
                    </button>
                    <button className="btn btn-danger"
                        onClick={() => this.props.togglerModalDelete(task)}>
                        <FontAwesomeIcon icon={faTrashAlt}/>
                    </button>
                </td>
          </tr>
        )
    }
}
