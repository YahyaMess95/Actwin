package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.traccar.UserDevices;

public interface UserDevicesRepository extends JpaRepository<UserDevices, Long> {

}
