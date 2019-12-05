package co.com.poli.trabajofinal.dao;

import co.com.poli.trabajofinal.model.PlayList;
import org.springframework.data.repository.CrudRepository;

public interface IPlayListDao extends CrudRepository<PlayList,String> { }
