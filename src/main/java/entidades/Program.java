package entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import bean.LanceBean;
import dao.LanceDAO;
import util.JPAUtil;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManager em = JPAUtil.getEntityManager();

		LanceDAO dao = new LanceDAO();
		LanceBean bean = new LanceBean();
		Lance c1 = new Lance(2);


		bean.Inserir();
	}

}
