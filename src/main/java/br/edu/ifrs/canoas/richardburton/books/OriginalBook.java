package br.edu.ifrs.canoas.richardburton.books;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import org.hibernate.search.annotations.ContainedIn;

@Entity
@JsonInclude(Include.NON_NULL)
public class OriginalBook extends Book {

    @NotNull
    @OneToMany(mappedBy = "original")
    @ContainedIn
    @JsonBackReference
    private List<TranslatedBook> translations;

    public List<TranslatedBook> getTranslations() {
        return translations;
    }

    public void setTranslations(List<TranslatedBook> translations) {
        this.translations = translations;
    }

}
