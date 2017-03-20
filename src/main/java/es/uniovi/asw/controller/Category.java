package es.uniovi.asw.controller;

import java.util.List;
import es.uniovi.asw.model.Proposal;
import es.uniovi.asw.model.filtrable.Filtrable;

public class Category implements Filter{
	
	private es.uniovi.asw.model.Category category;
	
	public Category(es.uniovi.asw.model.Category category) {
		this.category = category;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Filtrable> filter(List<Filtrable> listOfFiltables) {
		List<Proposal> lst = (List<Proposal>) listOfFiltables.stream().filter(x -> x instanceof Proposal);
		List<Filtrable> ret = (List<Filtrable>) lst.stream().map( x -> x.getCategory().equals(this.category));
		return ret;
		
	}

}
