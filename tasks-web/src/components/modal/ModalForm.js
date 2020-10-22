import React, { Component } from 'react';
import { Modal, ModalBody, ModalFooter, ModalHeader } from 'reactstrap';

class ModalAdd extends Component {

    state = {
        task: this.props.task
    }

    componentWillReceiveProps(nextProps) {
        // This will erase any local state updates!
        // Do not do this.
        this.setState({ task: nextProps.task });
      }

    handleChange = async e => {
        e.persist();
        await this.setState({
            task:{
                ...this.state.task,
                [e.target.name]: e.target.value
            }
        });
    }

    handleChangeCheckbox = async e =>{
        e.persist();
        await this.setState({
          task:{
            ...this.state.task,
            vigente: !this.state.task.vigente
          }
        });
    }

    onSubmit=(e)=>{
        this.props.saveTask(this.state.task);
        e.preventDefault();
    }

    render() {
        const {task}=this.state;
        return (
            <Modal isOpen={this.props.isOpen}>
                <ModalHeader style={{display: 'block'}}>
                {task?"Actualizar":"Agregar"}
                    <span style={{float: 'right'}}
                        onClick={()=>{
                            this.props.togglerModalForm(null);
                        }}>x
                    </span>
                </ModalHeader>
                <form onSubmit={this.onSubmit}>
                    <ModalBody>
                        {/* <div className="form-group">
                            <label htmlFor="id">ID</label>
                            <input className="form-control" type="text" name="id" id="id" readOnly
                                value={task.id}/>
                        </div> */}
                        <div className="form-group">
                            <label htmlFor="description">Descripción</label>
                            <textarea className="form-control" name="description" id="description"
                                value={task.description}
                                onChange={this.handleChange}/>          
                        </div>
                        <div className="form-check">
                            <input className="form-check-input" type="checkbox" name="vigente" id="vigente"
                                defaultChecked={task.checkbox}
                                value={task.checkbox}
                                onClick={this.handleChangeCheckbox}
                                />
                            <label className="form-check-label" htmlFor="vigente">Vigente</label>
                        </div>
                    </ModalBody>
                    <ModalFooter>
                        <button className="btn btn-success" type="submit">Guardar</button>
                        <button className="btn btn-danger" type="button" onClick={()=>{
                            this.props.togglerModalForm(null);
                        }}>Cancelar</button>
                    </ModalFooter>
                </form>
            </Modal>
        )
    }
}

export default ModalAdd;