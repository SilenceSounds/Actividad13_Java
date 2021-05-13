package net.codejava.repositories;

import net.codejava.entity.IMC_Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMCRepository extends JpaRepository<IMC_Data, Long> {

}
