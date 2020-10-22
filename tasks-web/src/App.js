import React, { Component } from 'react';
import axios from "axios";
import "bootstrap/dist/css/bootstrap.min.css";

//components
import Tasks from './components/Tasks';
import ModalDelete from './components/modal/ModalDelete';
import ModalForm from './components/modal/ModalForm';

//constants
import * as constants from '../src/constants/constants';

class App extends Component {
  state = {
    tasks:[],
    modalForm: false,
    modalDelete: false,
    task: {
      id: undefined,
      description: "",
      vigente: false
    }
  }
  
  componentDidMount(){
    this.getTasks();
  }
  
  getTasks=()=>{
    axios.get(constants.GET_TASKS).then(response=>{
      this.setState({tasks: response.data});
    }).catch(error=>{ console.log("Error f(getTasks)", error.message); })
  }

  deleteTask=(id)=>{
    axios.delete(constants.DELETE_TASKS+id).then(() =>{
      this.getTasks();
    }).catch(error=>{ 
      console.log("Error f(deleteTask)", error.message); 
    }).finally(() => {
      this.setState({modalDelete: !this.state.modalDelete});
    });
  }

  saveTask=(task)=>{
    if(task.id===undefined){
      this.addTask(task);
    }else{
      this.updateTask(task);
    }
  }

  addTask=async(task)=>{
    await axios.post(constants.ADD_TASK,task).then(response=>{
      this.getTasks();
    }).catch(error=>{ 
      console.log("Error f(addTask)", error.message); 
    }).finally(() => {
      this.setState({modalForm: !this.state.modalForm});
      this.cleanForm();
    });
  }
  
  updateTask=(task)=>{
    axios.put(constants.UPDATE_TASK,task).then(response=>{
      this.getTasks();
    }).catch(error=>{ 
      console.log("Error f(updateTask)", error.message); 
    }).finally(() => {
      this.setState({modalForm: !this.state.modalForm});
      this.cleanForm();
    });
  }

  togglerModalDelete=(task)=>{
    this.setState({task:task, modalDelete: !this.state.modalDelete});
  }

  togglerModalForm=(task)=>{
    this.setState({task:task?task:this.state.task, modalForm: !this.state.modalForm});
    if(this.state.modalForm===true){
      this.cleanForm();
    }
  }

  cleanForm=()=>{
    this.setState({
        task: {
            id: undefined,
            description: "",
            vigente: false
        }
    });
}

  render(){
    return (
      <div className="App container">
        <div className="row m-5">
        <button className="btn btn-success" 
          onClick={()=>{this.togglerModalForm(null)}} >
            Agregar Tarea
        </button>
        </div>
        <Tasks 
          tasks={this.state.tasks}
          selectTask={this.selectTask}
          togglerModalDelete={this.togglerModalDelete}
          togglerModalForm={this.togglerModalForm}
          />
        <ModalDelete 
          isOpen={this.state.modalDelete}
          task={this.state.task}
          deleteTask={this.deleteTask}
          togglerModalDelete={this.togglerModalDelete}
          />
        <ModalForm 
          isOpen={this.state.modalForm}
          task={this.state.task}
          togglerModalForm={this.togglerModalForm}
          saveTask={this.saveTask}
          />
      </div>
    );
  }
}
export default App;
