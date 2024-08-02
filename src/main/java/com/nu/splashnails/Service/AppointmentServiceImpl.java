package com.nu.splashnails.Service;

import com.nu.splashnails.Entity.Appointment;
import com.nu.splashnails.Repository.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class  AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepo appointmentRepo;

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepo.findAll();
    }

    @Override
    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepo.findById(id);
    }

    @Override
    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepo.save(appointment);
    }

    @Override
    public Appointment updateAppointment(Long id, Appointment appointment) {
        return appointmentRepo.findById(id)
                .map(existingAppointment -> {
                    existingAppointment.setUserDet(appointment.getUserDet());
                    existingAppointment.setEmail(appointment.getEmail());
                    existingAppointment.setContactNo(appointment.getContactNo());
                    existingAppointment.setDescription(appointment.getDescription());
                    existingAppointment.setAppointmentDate(appointment.getAppointmentDate());
                    return appointmentRepo.save(existingAppointment);
                }).orElseThrow(() -> new RuntimeException("Appointment not found"));
    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentRepo.deleteById(id);
    }

}
