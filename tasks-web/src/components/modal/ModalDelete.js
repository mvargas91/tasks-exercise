import React, { Component } from 'react';
import { Modal, ModalBody, ModalFooter } from 'reactstrap';

export default class ModalDelete extends Component {
    render() {
        const {task}=this.props;
        return (
            <Modal isOpen={this.props.isOpen}>
                <ModalBody>
                Estás seguro que deseas eliminar la tarea {task && task.id}
                </ModalBody>
                <ModalFooter>
                <button className="btn btn-danger" onClick={()=>this.props.deleteTask(task.id)}>Sí</button>
                <button className="btn btn-secundary" onClick={()=>this.props.togglerModalDelete(null)}>No</button>
                </ModalFooter>
            </Modal>
        )
    }
}
