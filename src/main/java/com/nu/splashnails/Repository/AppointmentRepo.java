package com.nu.splashnails.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nu.splashnails.Entity.Appointment;

public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
}
