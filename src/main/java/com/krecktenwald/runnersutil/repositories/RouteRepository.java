package com.krecktenwald.runnersutil.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krecktenwald.runnersutil.domain.entities.Route;
import com.krecktenwald.runnersutil.domain.entities.Run;

public interface RouteRepository extends JpaRepository<Route, String> {
}
