package br.edu.ifrs.canoas.richardburton.books;

import br.edu.ifrs.canoas.richardburton.EntityService;

import javax.ejb.Local;
import java.util.List;

@Local
public interface AuthorService extends EntityService<Author, Long> {

    List<Author> search(Long afterId, int pageSize, String queryString);

    Author retrieve(String name);
}