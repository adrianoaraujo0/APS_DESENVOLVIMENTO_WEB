package bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.LanceDAO;
import entidades.Lance;

@ManagedBean
@ViewScoped
public class LanceBean {

	private Lance lance;
	private ArrayList<Lance> lances;

	public Lance getLance() {
		return lance;
	}

	public void setLance(Lance lance) {
		this.lance = lance;
	}

	public ArrayList<Lance> getLances() {
		return lances;
	}

	public void setLances(ArrayList<Lance> lances) {
		this.lances = lances;
	}

	public void prepararInserir() {

		this.lance = new Lance();

	}

	public int aleatorio() {
		Random aleatorio = new Random();
		int x = aleatorio.nextInt(5) + 1;
		return x;

	}

	public void Inserir() {
		this.lance = new Lance();
		LanceDAO dao = new LanceDAO();

		lance.setV1(aleatorio());
		lance.setV2(aleatorio());
		lance.setV3(aleatorio());
		lance.setDescricao("Lance " + (dao.listar().get(0).getId() + 1));

		dao.salvar(lance);
		lances = dao.listar();

	}

	public void carregarListagem() {

		LanceDAO dao = new LanceDAO();
		lances = dao.listar();

	}

	public void editar() {

		LanceDAO dao = new LanceDAO();
		lances = dao.listar();

		dao.merge(lance);

	}

	public void excluir() {
		LanceDAO dao = new LanceDAO();

		dao.remover(lance);

		lances = dao.listar();

	}
}
