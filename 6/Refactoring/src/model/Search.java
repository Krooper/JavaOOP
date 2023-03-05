package model;

import service.SearchService;

import java.util.HashSet;

public class Search {
    public Search(SearchService request) {
        this.request = request;
    }

    public SearchService getRequest() {
        return request;
    }

    public void setRequest(SearchService request) {
        this.request = request;
    }

    private SearchService request;
    public HashSet<Notebook> getFilteredNotes () {
        HashSet<Notebook> filteredNotes = new HashSet<>();
        for (String brand : request.getBrands()){
            for (int ram : request.getRams()){
                for (int rom : request.getRoms()){
                    for (String proc : request.getProcs()){
                        for (double screen : request.getScreens()){
                            for (String os : request.getOss()){
                                for (String colour : request.getColours()){
                                    for (boolean inStock : request.getInStocks()){
                                        for (Notebook note : Shop.getNotebooks()) {
                                            if (note.getBrand().equals(brand) && note.getRam() == ram
                                                    && note.getRom() == rom
                                                    && note.getProc().equals(proc) && note.getScreenDiag() == screen
                                                    && note.getOs().equals(os) && note.getColour().equals(colour)
                                                    && note.getInStock() == inStock &&
                                                    note.getPrice() < request.getMaxPrice()){
                                                filteredNotes.add(note);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return filteredNotes;
    }

    public void printFilteredNotes(){
        System.out.println();
        if (getFilteredNotes().size() != 0) {
            System.out.println("List of notebooks that fit the filter: ");
            for (Notebook note : getFilteredNotes()) {
                System.out.println(note.toString());
            }
        } else {
            System.out.println("There are no notebooks that fit your criteria");
        }

    }
}
