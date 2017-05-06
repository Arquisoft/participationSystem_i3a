package es.uniovi.asw.filters;

import java.util.List;

import es.uniovi.asw.model.filtrable.Filtrable;

public class Popularity implements Filter{


	@Override
	public List<Filtrable> filter(List<Filtrable> listOfFiltables) {
		
		//FALTA ORDENAR
		//List<Comment> lst = (List<Comment>) listOfFiltables.stream().filter(x -> x instanceof Comment);
		//List<Filtrable> ret = (List<Filtrable>) lst.stream().map( x -> x.getPositiveVotes());
		//return ret;
		return null;
	}

}
