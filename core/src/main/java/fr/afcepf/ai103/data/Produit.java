package fr.afcepf.ai103.data;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the produit database table.
 * 
 */
@Entity
@NamedQuery(name="Produit.findAll", query="SELECT p FROM Produit p")
public class Produit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int numero;

	private String code;

	private int id_prod;

	private String image;

	private String label;

	private String libelle_prod;

	private double prix;

	//bi-directional many-to-one association to Conservation
	@ManyToOne
	@JoinColumn(name="Id_conserv")
	private Conservation conservation;

	//bi-directional many-to-one association to SousCategorie
	@ManyToOne
	@JoinColumn(name="Id_sous_cat")
	private SousCategorie sousCategorie;

	//bi-directional many-to-one association to Unite
	@ManyToOne
	@JoinColumn(name="Id_unite")
	private Unite unite;

	//bi-directional many-to-one association to Stock
	@OneToMany(mappedBy="produit")
	private List<Stock> stocks;

	public Produit() {
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getId_prod() {
		return this.id_prod;
	}

	public void setId_prod(int id_prod) {
		this.id_prod = id_prod;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLibelle_prod() {
		return this.libelle_prod;
	}

	public void setLibelle_prod(String libelle_prod) {
		this.libelle_prod = libelle_prod;
	}

	public double getPrix() {
		return this.prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Conservation getConservation() {
		return this.conservation;
	}

	public void setConservation(Conservation conservation) {
		this.conservation = conservation;
	}

	public SousCategorie getSousCategorie() {
		return this.sousCategorie;
	}

	public void setSousCategorie(SousCategorie sousCategorie) {
		this.sousCategorie = sousCategorie;
	}

	public Unite getUnite() {
		return this.unite;
	}

	public void setUnite(Unite unite) {
		this.unite = unite;
	}

	public List<Stock> getStocks() {
		return this.stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	public Stock addStock(Stock stock) {
		getStocks().add(stock);
		stock.setProduit(this);

		return stock;
	}

	public Stock removeStock(Stock stock) {
		getStocks().remove(stock);
		stock.setProduit(null);

		return stock;
	}

}