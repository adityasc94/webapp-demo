package com.webapp.demo.service;

import com.webapp.demo.domain.*;
import com.webapp.demo.model.*;
import com.webapp.demo.repository.EmployeeInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeInfoRepository employeeRepository;

    public ResponseObject addEmployee(RequestObject request) {
        ResponseObject response = new ResponseObject();
        EmployeeEntity employeeEntity = mapModelToEntity(request.getEmployeeModel());
        employeeRepository.save(employeeEntity);
        return response;
    }

    @Transactional
    public ResponseObject updateEmployee(RequestObject request) {
        ResponseObject response = new ResponseObject();
        EmployeeEntity employeeEntity = mapModelToEntity(request.getEmployeeModel());
        employeeRepository.delete(employeeEntity);
        employeeRepository.save(employeeEntity);
        return response;
    }

    public ResponseObject deleteEmployee(String empId) {
        ResponseObject response = new ResponseObject();
        employeeRepository.deleteById(empId);
        return response;
    }

    public ResponseObject getAllEmployees() {
        ResponseObject response = new ResponseObject();
        List<EmployeeModel> employeeModels = new ArrayList<>();
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        if (!CollectionUtils.isEmpty(employeeEntities)) {
            employeeEntities.stream().forEach(employeeEntity -> {
                EmployeeModel employeeModel = mapEntityToModel(employeeEntity);
                employeeModels.add(employeeModel);
            });
        }
        response.setEmployeeModelList(employeeModels);
        return response;
    }

    public ResponseObject getEmployee(String empId) {
        ResponseObject response = new ResponseObject();
        List<EmployeeModel> employeeModels = new ArrayList<>();
        EmployeeEntity employeeEntity = employeeRepository.findById(empId).orElse(null);
        if (Objects.nonNull(employeeEntity)) {
            EmployeeModel employeeModel = mapEntityToModel(employeeEntity);
            employeeModels.add(employeeModel);
        }
        response.setEmployeeModelList(employeeModels);
        return response;
    }


    private EmployeeModel mapEntityToModel(EmployeeEntity employeeEntity) {
        EmployeeModel employeeModel = new EmployeeModel();
        BeanUtils.copyProperties(employeeEntity, employeeModel);
        if (!CollectionUtils.isEmpty(employeeEntity.getEmployeeAddressEntities())) {
            List<EmployeeAddressModel> addressModels = new ArrayList<>();
            employeeEntity.getEmployeeAddressEntities().stream().forEach(addressEntity -> {
                EmployeeAddressModel addressModel = new EmployeeAddressModel();
                BeanUtils.copyProperties(addressEntity, addressModel);
                addressModels.add(addressModel);
            });
            employeeModel.setEmployeeAddresses(addressModels);
        }
        if (!CollectionUtils.isEmpty(employeeEntity.getEmployeeFamilyEntities())) {
            List<EmployeeFamilyModel> familyModels = new ArrayList<>();
            employeeEntity.getEmployeeFamilyEntities().stream().forEach(familyEntity -> {
                EmployeeFamilyModel familyModel = new EmployeeFamilyModel();
                BeanUtils.copyProperties(familyEntity, familyModel);
                familyModels.add(familyModel);
            });
            employeeModel.setEmployeeFamilies(familyModels);
        }
        if (!CollectionUtils.isEmpty(employeeEntity.getEmployeeCourseEntities())) {
            List<EmployeeCourseModel> courseModels = new ArrayList<>();
            employeeEntity.getEmployeeCourseEntities().stream().forEach(courseEntity -> {
                EmployeeCourseModel courseModel = new EmployeeCourseModel();
                BeanUtils.copyProperties(courseEntity, courseModel);
                courseModels.add(courseModel);
            });
            employeeModel.setEmployeeCourses(courseModels);
        }
        if (!CollectionUtils.isEmpty(employeeEntity.getEmployeeDutyEntities())) {
            List<EmployeeDutyModel> dutyModels = new ArrayList<>();
            employeeEntity.getEmployeeDutyEntities().stream().forEach(dutyEntity -> {
                EmployeeDutyModel dutyModel = new EmployeeDutyModel();
                BeanUtils.copyProperties(dutyEntity, dutyModel);
                dutyModels.add(dutyModel);
            });
            employeeModel.setEmployeeDuties(dutyModels);
        }
        if (!CollectionUtils.isEmpty(employeeEntity.getEmployeePunishmentEntities())) {
            List<EmployeePunishmentModel> punishmentModels = new ArrayList<>();
            employeeEntity.getEmployeePunishmentEntities().stream().forEach(punishmentEntity -> {
                EmployeePunishmentModel punishmentModel = new EmployeePunishmentModel();
                BeanUtils.copyProperties(punishmentEntity, punishmentModel);
                punishmentModels.add(punishmentModel);
            });
            employeeModel.setEmployeePunishments(punishmentModels);
        }
        if (!CollectionUtils.isEmpty(employeeEntity.getEmployeeSportEntities())) {
            List<EmployeeSportModel> sportModels = new ArrayList<>();
            employeeEntity.getEmployeeSportEntities().stream().forEach(sportEntity -> {
                EmployeeSportModel sportModel = new EmployeeSportModel();
                BeanUtils.copyProperties(sportEntity, sportModel);
                sportModels.add(sportModel);
            });
            employeeModel.setEmployeeSports(sportModels);
        }
        return employeeModel;
    }

    private EmployeeEntity mapModelToEntity(EmployeeModel employeeModel) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employeeModel, employeeEntity);
        if (!CollectionUtils.isEmpty(employeeModel.getEmployeeAddresses())) {
            List<EmployeeAddressEntity> addressEntities = new ArrayList<>();
            employeeModel.getEmployeeAddresses().stream().forEach(addressModel -> {
                EmployeeAddressEntity addressEntity = new EmployeeAddressEntity();
                BeanUtils.copyProperties(addressModel, addressEntity);
                addressEntity.setEmp(employeeEntity);
                addressEntities.add(addressEntity);
            });
            employeeEntity.setEmployeeAddressEntities(addressEntities);
        }
        if (!CollectionUtils.isEmpty(employeeModel.getEmployeeFamilies())) {
            List<EmployeeFamilyEntity> familyEntities = new ArrayList<>();
            employeeModel.getEmployeeFamilies().stream().forEach(familyModel -> {
                EmployeeFamilyEntity familyEntity = new EmployeeFamilyEntity();
                BeanUtils.copyProperties(familyModel, familyEntity);
                familyEntity.setEmp(employeeEntity);
                familyEntities.add(familyEntity);
            });
            employeeEntity.setEmployeeFamilyEntities(familyEntities);
        }
        if (!CollectionUtils.isEmpty(employeeModel.getEmployeeCourses())) {
            List<EmployeeCourseEntity> courseEntities = new ArrayList<>();
            employeeModel.getEmployeeCourses().stream().forEach(courseModel -> {
                EmployeeCourseEntity courseEntity = new EmployeeCourseEntity();
                BeanUtils.copyProperties(courseModel, courseEntity);
                courseEntity.setEmp(employeeEntity);
                courseEntities.add(courseEntity);
            });
            employeeEntity.setEmployeeCourseEntities(courseEntities);
        }
        if (!CollectionUtils.isEmpty(employeeModel.getEmployeeDuties())) {
            List<EmployeeDutyEntity> dutyEntities = new ArrayList<>();
            employeeModel.getEmployeeDuties().stream().forEach(dutyModel -> {
                EmployeeDutyEntity dutyEntity = new EmployeeDutyEntity();
                BeanUtils.copyProperties(dutyModel, dutyEntity);
                dutyEntity.setEmp(employeeEntity);
                dutyEntities.add(dutyEntity);
            });
            employeeEntity.setEmployeeDutyEntities(dutyEntities);
        }
        if (!CollectionUtils.isEmpty(employeeModel.getEmployeePunishments())) {
            List<EmployeePunishmentEntity> punishmentEntities = new ArrayList<>();
            employeeModel.getEmployeePunishments().stream().forEach(punishmentModel -> {
                EmployeePunishmentEntity punishmentEntity = new EmployeePunishmentEntity();
                BeanUtils.copyProperties(punishmentModel, punishmentEntity);
                punishmentEntity.setEmp(employeeEntity);
                punishmentEntities.add(punishmentEntity);
            });
            employeeEntity.setEmployeePunishmentEntities(punishmentEntities);
        }
        if (!CollectionUtils.isEmpty(employeeModel.getEmployeeSports())) {
            List<EmployeeSportEntity> sportEntities = new ArrayList<>();
            employeeModel.getEmployeeSports().stream().forEach(sportModel -> {
                EmployeeSportEntity sportEntity = new EmployeeSportEntity();
                BeanUtils.copyProperties(sportModel, sportEntity);
                sportEntity.setEmp(employeeEntity);
                sportEntities.add(sportEntity);
            });
            employeeEntity.setEmployeeSportEntities(sportEntities);
        }
        return employeeEntity;
    }

}
