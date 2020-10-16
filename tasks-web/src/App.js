import React, { Component } from 'react';
import './App.css';
import axios from "axios";
import "bootstrap/dist/css/bootstrap.min.css";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faEdit, faTrashAlt, faCheck, faTimes } from '@fortawesome/free-solid-svg-icons';
import { Modal, ModalBody, ModalFooter, ModalHeader } from 'reactstrap';
import Moment from 'moment';
import * as constants from '../src/constants/constants';

class App extends Component {

state = {
  data:[],
  modalInsertar: false,
  modalEliminar: false,
  checkbox: false,
  form:{
    id: '',
    description: '',
    dateCreation: '',
    vigente: false,
    tipoModal: ''
  }
}

getTasks=()=>{
  axios.get(constants.GET_TASKS).then(response=>{
    this.setState({data: response.data});
  }).catch(error=>{ console.log(error.message); })
}

addTask=async()=>{
  delete this.state.form.id;
  await axios.post(constants.ADD_TASK,this.state.form).then(response=>{
    this.modalInsertar();
    this.getTasks();
  }).catch(error=>{ console.log(error.message); })
}

updateTask=()=>{
  axios.put(constants.UPDATE_TASK, this.state.form).then(response=>{
    this.modalInsertar();
    this.getTasks();
  })
}

deleteTask=()=>{
  axios.delete(constants.DELETE_TASKS+this.state.form.id).then(response=>{
    this.setState({modalEliminar: false});
    this.getTasks();
  })
}

modalInsertar=()=>{
  this.setState({modalInsertar: !this.state.modalInsertar});
}

handleChangeCheckbox = () =>{
  this.setState({
    checkbox: !this.state.checkbox,
    form:{
      ...this.state.form,
      vigente: !this.state.checkbox
    }
  });
}

seleccionarEmpresa=(task)=>{
  this.setState({
    tipoModal: 'actualizar',
    checkbox: task.vigente,
    form: {
      id: task.id,
      description: task.description,
      dateCreation: task.dateCreation,
      vigente: task.vigente
    }
  })
}

handleChange = async e => {
  e.persist();
  await this.setState({
    form:{
      ...this.state.form,
      [e.target.name]: e.target.value
    }
  });
  console.log(this.state.form);
}

componentDidMount() {
  this.getTasks();
}
  

render(){
  const {form}=this.state;
  return (

  <div className="App">
  <br /><br /><br />
  <button className="btn btn-success" onClick={()=>{this.setState({form: null, tipoModal: 'insertar'}); this.modalInsertar()}}>Agregar Tarea</button>
  <br /><br />
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
        {this.state.data.map(task =>{
          return(
          <tr key={task.id} >
          <td>{task.id}</td>
          <td>{task.description}</td>          
          <td>
            {Moment(task.dateCreation).format('YYYY-MM-DD')}
          </td>
          <td>
            <FontAwesomeIcon icon={task.vigente?faCheck:faTimes}/>
          </td>
          <td>
              <button className="btn btn-primary" onClick={()=>{this.seleccionarEmpresa(task); this.modalInsertar()}}><FontAwesomeIcon icon={faEdit}/></button>
              {"   "}
              <button className="btn btn-danger" onClick={()=>{this.seleccionarEmpresa(task); this.setState({modalEliminar: true})}}><FontAwesomeIcon icon={faTrashAlt}/></button>
              </td>
          </tr>
          )
        })}
      </tbody>
    </table>

    <Modal isOpen={this.state.modalInsertar}>
      <ModalHeader style={{display: 'block'}}>
        <span style={{float: 'right'}} onClick={()=>this.modalInsertar()}>x</span>
      </ModalHeader>
      <ModalBody>
        <div className="form-group">
          <label htmlFor="id">ID</label>
          <input className="form-control" type="text" name="id" id="id" readOnly
            onChange={this.handleChange} value={form?form.id: this.state.data.length+1}/>
        </div>
        <div class="form-group">
        <label htmlFor="description">Descripción</label>
          <textarea className="form-control" name="description" id="description"
            value={form?form.description: ''} onChange={this.handleChange} />          
        </div>
        <div class="form-check">
          <input className="form-check-input" type="checkbox" name="vigente" id="vigente" 
            defaultChecked={this.state.checkbox}
            value={this.state.checkbox}
            onClick={()=>this.handleChangeCheckbox()}/>
          <label htmlFor="vigente" class="form-check-label">Vigente</label>
        </div>
      </ModalBody>

      <ModalFooter>
        {this.state.tipoModal=='insertar'?
        <button className="btn btn-success" onClick={()=>this.addTask()}>
        Insertar
        </button>: <button className="btn btn-primary" onClick={()=>this.updateTask()}>
        Actualizar
        </button>
        }
        <button className="btn btn-danger" onClick={()=>this.modalInsertar()}>Cancelar</button>
      </ModalFooter>
    </Modal>

    <Modal isOpen={this.state.modalEliminar}>
      <ModalBody>
        Estás seguro que deseas eliminar a la empresa {form && form.nombre}
      </ModalBody>
      <ModalFooter>
        <button className="btn btn-danger" onClick={()=>this.deleteTask()}>Sí</button>
        <button className="btn btn-secundary" onClick={()=>this.setState({modalEliminar: false})}>No</button>
      </ModalFooter>
    </Modal>
  </div>
  );
}
}
export default App;
