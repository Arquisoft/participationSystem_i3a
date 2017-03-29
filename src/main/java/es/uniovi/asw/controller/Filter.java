package es.uniovi.asw.controller;

import java.util.List;

import es.uniovi.asw.model.filtrable.Filtrable;

public interface Filter {

	
	
	List<Filtrable> filter(List<Filtrable> listOfFiltrables);
}
