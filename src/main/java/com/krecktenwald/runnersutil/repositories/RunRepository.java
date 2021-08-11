package com.krecktenwald.runnersutil.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krecktenwald.runnersutil.domain.Run;

public interface RunRepository extends JpaRepository<Run, Long> {
}
