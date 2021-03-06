package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.task.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import javax.validation.constraints.Max;
import java.util.List;

@Transactional
@Repository
public interface CompanyDao extends CrudRepository<Company, Integer> {
    @Query(nativeQuery = true)
    List<Company> retrieveCompanyNameByFirstThreeLetters(@Param("NAME_THREE_LETTERS") String nameThreeLetters);

    @Query
    List<Company> retrieveCompaniesByAnyThreeLettersOfName(@Param("ANY_THREE_LETTERS") String anyThreeLetters);
}