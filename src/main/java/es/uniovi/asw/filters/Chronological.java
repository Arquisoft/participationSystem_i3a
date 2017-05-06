package es.uniovi.asw.filters;

import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.model.filtrable.Filtrable;

public class Chronological implements Filter{


	@Override
	public List<Filtrable> filter(List<Filtrable> listOfFiltables) {
		
		
	//	List<Comment> lst = (List<Comment>) listOfFiltables.stream().filter(x -> x instanceof Comment);
	//	List<Filtrable> ret = (List<Filtrable>) lst.stream().map( x -> x.getDate().orderBy(x.getDate()));
		List<Filtrable> ret = new ArrayList<Filtrable>();
		return ret;
	}
}
