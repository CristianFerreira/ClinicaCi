package main.java.bean;


import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import main.java.domain.Usuario;
import main.java.service.UsuarioService;
import main.java.util.ClinicaEntityManager;

@Named
@RequestScoped
public class UsuarioBean {

    private Usuario usuarioCadastrado, usuarioSelecionado;
    private List<Usuario> usuario, usuarioFiltrados;

    @PostConstruct
    public void init() {
        usuarioCadastrado = new Usuario();
        usuarioSelecionado = new Usuario();
        usuario = new UsuarioService(new ClinicaEntityManager("ClinicaPU")).findAll();
    }

    public void cadastrarMedico() {
        usuarioCadastrado.setTipoUsuario(30);
        new UsuarioService(new ClinicaEntityManager("ClinicaPU")).save(usuarioCadastrado);
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogCadastroMedico').hide();");
        addMessage("MÃ©dico cadastrado com sucesso!");
    }

    public void editarMedico() {
        new UsuarioService(new ClinicaEntityManager("ClinicaPU")).edit(usuarioSelecionado);
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogVisualizaMedico').hide();");
        addMessage("MÃ©dico editado com sucesso!");
    }

    public void deletarMedico() {
        new UsuarioService(new ClinicaEntityManager("ClinicaPU")).remove(usuarioSelecionado);
    }
    
//    public void listarMedicos() {
//        new MedicoService(new ClinicaEntityManager("ClinicaPU")).findAll();
//    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void onRowSelect(SelectEvent event) {
    }

    public Usuario getMedicoCadastrado() {
        return usuarioCadastrado;
    }

    public void setUsuarioCadastrado(Usuario medicoCadastrado) {
        this.usuarioCadastrado = medicoCadastrado;
    }

    public Usuario getMedicoSelecionado() {
        return usuarioSelecionado;
    }

    public void setMedicoSelecionado(Usuario medicoSelecionado) {
        this.usuarioSelecionado = medicoSelecionado;
    }

    public List<Usuario> getMedicos() {
        return usuario;
    }

    public void setMedicos(List<Usuario> medicos) {
        this.usuario = medicos;
    }

    public List<Usuario> getMedicosFiltrados() {
        return usuarioFiltrados;
    }

    public void setMedicosFiltrados(List<Usuario> medicosFiltrados) {
        this.usuarioFiltrados = medicosFiltrados;
    }

}
