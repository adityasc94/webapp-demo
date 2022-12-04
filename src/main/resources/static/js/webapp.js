var employee_table;
function loadEmployeeTableData() {
    var getAllEmpUrl = 'http://localhost:8080/employee/get-all';
    $.ajax({
        url: getAllEmpUrl,
        type: 'GET',
        contentType: 'application/json',
        dataType: 'json',
        success: function (data) {
            employee_table.clear().draw();
            employee_table.rows.add(data.employeeList).draw();
        },
        error: function (data) {
            console.log('error: ' + JSON.stringify(data));
            alert('Failed to load data!');
        }
    });
}

function constructEmployeeObj() {
    var employee = {
        "id": $('#empId').val().trim(),
        "empRank": $('#empRank').val(),
        "trade": $('#trade').val(),
        "empBty": $('#empBty').val(),
        "empName": $('#empName').val(),
        "fatherName": $('#fatherName').val(),
        "bloodGroup": $('#bloodGroup').val(),
        "motherName": $('#motherName').val(),
        "bankAccNum": $('#bankAccNum').val(),
        "nokDetails": $('#nokDetails').val(),
        "panNum": $('#panNum').val(),
        "mobileNumNok": $('#mobileNumNok').val(),
        "mobileNumOwn": $('#mobileNumOwn').val(),
        "aadhaarNum": $('#aadhaarNum').val(),
        "drivingLicNum": $('#drivingLicNum').val(),
        "height": $('#height').val(),
        "weight": $('#weight').val(),
        "lifeStyleDisease": $('#lifeStyleDisease').val(),
        "dateOfBirth": $('#dateOfBirth').val(),
        "dateOfEntry": $('#dateOfEntry').val(),
        "tradeCl": $('#tradeCl').val(),
        "civQualification": $('#civQualification').val(),
        "mr": $('#mr').val(),
        "idCardNum": $('#idCardNum').val(),
        "idCardIssuer": $('#idCardIssuer').val(),
        "idCardIssueDate": $('#idCardIssueDate').val(),
        "leaveEncashed": $('#leaveEncashed').val(),
        "impApptsInService": $('#impApptsInService').val(),
        "hobbies": $('#hobbies').val(),
        "civCase": $('#civCase').val(),
        "familyFued": $('#familyFued').val(),
        "vehicle": $('#vehicle').val(),
        "computerKnowledge": $('#computerKnowledge').val(),
        "misc": $('#misc').val(),
        "employeeAddresses": [],
        "employeeFamilies": [],
        "employeeCourses": [],
        "employeeDuties": [],
        "employeePunishments": [],
        "employeeSports": []
    }
    var permAddress = {};
    permAddress.village = $('#permVillage').val();
    permAddress.post = $('#permPost').val();
    permAddress.tehsil = $('#permTehsil').val();
    permAddress.district = $('#permDistrict').val();
    permAddress.state = $('#permState').val();
    permAddress.pin = $('#permPin').val();
    permAddress.addressType = 'P';
    employee.employeeAddresses.push(permAddress);
    var tempAddress = {};
    tempAddress.village = $('#tempVillage').val();
    tempAddress.post = $('#tempPost').val();
    tempAddress.tehsil = $('#tempTehsil').val();
    tempAddress.district = $('#tempDistrict').val();
    tempAddress.state = $('#tempState').val();
    tempAddress.pin = $('#tempPin').val();
    tempAddress.addressType = 'T';
    employee.employeeAddresses.push(tempAddress);
    for (var i=1; i<=5; i++) {
        if ($('#fmName' + i).val())  {
            var familyMember = {};
            familyMember.memberName = $('#fmName' + i).val();
            familyMember.gender = $('#fmGender' + i).val();
            familyMember.age = $('#fmAge' + i).val();
            familyMember.qualification = $('#fmQlfcn' + i).val();
            employee.employeeFamilies.push(familyMember);
        }
    }
    for (var i=1; i<=2; i++) {
        if ($('#courseName' + i).val()) {
            var course = {};
            course.courseName = $('#courseName' + i).val();
            course.startDate = $('#courseStart' + i).val();
            course.endDate = $('#courseEnd' + i).val();
            course.grading = $('#courseGrade' + i).val();
            course.remarks = $('#courseRemark' + i).val();
            employee.employeeCourses.push(course);
        }
    }
    for (var i=1; i<=2; i++) {
        if ($('#ere' + i).val()) {
            var ereDuty = {};
            ereDuty.ereDetail = $('#ere' + i).val();
            ereDuty.startDate = $('#ereStart' + i).val();
            ereDuty.endDate = $('#ereEnd' + i).val();
            ereDuty.remarks = $('#ereRemark' + i).val();
            employee.employeeDuties.push(ereDuty);
        }
    }
    for (var i=1; i<=2; i++) {
        if ($('#pnshAwr' + i).val()) {
            var pnshment = {};
            pnshment.punishmentAwarded = $('#pnshAwr' + i).val();
            pnshment.offence = $('#offence' + i).val();
            pnshment.remarks = $('#pnshRemark' + i).val();
            employee.employeePunishments.push(pnshment);
        }
    }
    for (var i=1; i<=2; i++) {
        if ($('#sportPlayed' + i).val()) {
            var sport = {};
            sport.sportPlayed = $('#sportPlayed' + i).val();
            sport.sportLevel = $('#sportLevel' + i).val();
            sport.remarks = $('#sportRemark' + i).val();
            employee.employeeSports.push(sport);
        }
    }
    return employee;
}

function populateEmployeeForm(employee) {
    $('#empId').val(employee.id);
    $('#empRank').val(employee.empRank);
    $('#trade').val(employee.trade);
    $('#empBty').val(employee.empBty);
    $('#empName').val(employee.empName);
    $('#fatherName').val(employee.fatherName);
    $('#bloodGroup').val(employee.bloodGroup);
    $('#motherName').val(employee.motherName);
    $('#bankAccNum').val(employee.bankAccNum);
    $('#nokDetails').val(employee.nokDetails);
    $('#panNum').val(employee.panNum);
    $('#mobileNumNok').val(employee.mobileNumNok);
    $('#mobileNumOwn').val(employee.mobileNumOwn);
    $('#aadhaarNum').val(employee.aadhaarNum);
    $('#drivingLicNum').val(employee.drivingLicNum);
    $('#height').val(employee.height);
    $('#weight').val(employee.weight);
    $('#lifeStyleDisease').val(employee.lifeStyleDisease);
    $('#dateOfBirth').val(employee.dateOfBirth);
    $('#dateOfEntry').val(employee.dateOfEntry);
    $('#tradeCl').val(employee.tradeCl);
    $('#civQualification').val(employee.civQualification);
    $('#mr').val(employee.mr);
    $('#idCardNum').val(employee.idCardNum);
    $('#idCardIssuer').val(employee.idCardIssuer);
    $('#idCardIssueDate').val(employee.idCardIssueDate);
    $('#leaveEncashed').val(employee.leaveEncashed);
    $('#impApptsInService').val(employee.impApptsInService);
    $('#hobbies').val(employee.hobbies);
    $('#civCase').val(employee.civCase);
    $('#familyFued').val(employee.familyFued);
    $('#vehicle').val(employee.vehicle);
    $('#computerKnowledge').val(employee.computerKnowledge);
    $('#misc').val(employee.misc);
    if (Array.isArray(employee.employeeAddresses)) {
        for (var i=1; i<=2 && employee.employeeAddresses[i-1]; i++) {
            var address = employee.employeeAddresses[i-1];
            if (address.addressType == 'P') {
                $('#permVillage').val(address.village);
                $('#permPost').val(address.post);
                $('#permTehsil').val(address.tehsil);
                $('#permDistrict').val(address.district);
                $('#permState').val(address.state);
                $('#permPin').val(address.pin);
            } else if (address.addressType == 'T') {
                $('#tempVillage').val(address.village);
                $('#tempPost').val(address.post);
                $('#tempTehsil').val(address.tehsil);
                $('#tempDistrict').val(address.district);
                $('#tempState').val(address.state);
                $('#tempPin').val(address.pin);
            }
        }
    }
    if (Array.isArray(employee.employeeFamilies)) {
        for (var i=1; i<=5 && employee.employeeFamilies[i-1]; i++) {
            var familyMember = employee.employeeFamilies[i-1];
            $('#fmName' + i).val(familyMember.memberName);
            $('#fmGender' + i).val(familyMember.gender);
            $('#fmAge' + i).val(familyMember.age);
            $('#fmQlfcn' + i).val(familyMember.qualification);
        }
    }
    if (Array.isArray(employee.employeeCourses)) {
        for (var i=1; i<=2 && employee.employeeCourses[i-1]; i++) {
            var course = employee.employeeCourses[i-1];
            $('#courseName' + i).val(course.courseName);
            $('#courseStart' + i).val(course.startDate);
            $('#courseEnd' + i).val(course.endDate);
            $('#courseGrade' + i).val(course.grading);
            $('#courseRemark' + i).val(course.remarks);
        }
    }
    if (Array.isArray(employee.employeeDuties)) {
        for (var i=1; i<=2 && employee.employeeDuties[i-1]; i++) {
            var ereDuty = employee.employeeDuties[i-1];
            $('#ere' + i).val(ereDuty.ereDetail);
            $('#ereStart' + i).val(ereDuty.startDate);
            $('#ereEnd' + i).val(ereDuty.endDate);
            $('#ereRemark' + i).val(ereDuty.remarks);
        }
    }
    if (Array.isArray(employee.employeePunishments)) {
        for (var i=1; i<=2 && employee.employeePunishments[i-1]; i++) {
            var pnshment = employee.employeePunishments[i-1];
            $('#pnshAwr' + i).val(pnshment.punishmentAwarded);
            $('#offence' + i).val(pnshment.offence);
            $('#pnshRemark' + i).val(pnshment.remarks);
        }
    }
    if (Array.isArray(employee.employeeSports)) {
        for (var i=1; i<=2 && employee.employeeSports[i-1]; i++) {
            var sport = employee.employeeSports[i-1];
            $('#sportPlayed' + i).val(sport.sportPlayed);
            $('#sportLevel' + i).val(sport.sportLevel);
            $('#sportRemark' + i).val(sport.remarks);
        }
    }
}

function setSubmitBtnAction(action) {
    var submitBtn = $('#emp-submit-btn');
    submitBtn.data('btn-action', action);
    if (action == 'view') {
        submitBtn.attr('disabled',true);
    } else {
        submitBtn.removeAttr('disabled');
    }
}

$(document).ready(function() {
    $('.date-input').datepicker({
        format: 'dd/mm/yyyy',
        startView: 2,
        clearBtn: true,
        autoclose: true
    });

    $('#employeeTable thead tr')
        .clone(true)
        .addClass('filters')
        .appendTo('#employeeTable thead');

    employee_table = $('#employeeTable').DataTable({
        orderCellsTop: true,
        fixedHeader: true,
        pageLength: 20,
        lengthMenu: [20, 30, 50, 75, 100],
        order: [],
        paging: true,
        searching: true,
        info: true,
        columns: [
            {data: "id"},
            {data: "empRank"},
            {data: "trade"},
            {data: "empBty"},
            {data: "empName"},
            {data: "bloodGroup"},
            {data: "dateOfBirth"},
            {data: "dateOfEntry"},
            {data: "mobileNumOwn"},
            {
                data: "id", width: "150px", render: function (data) {
                    return '<button type="button" class="btn btn-secondary btn-sm mx-1 emp-view-btn" value="'+ data +'"><img src="images/eye.svg"></button>'
                        + '<button type="button" class="btn btn-warning btn-sm mx-1 emp-edit-btn" value="'+ data +'"><img src="images/pencil-square.svg"></button>'
                        + '<button type="button" class="btn btn-danger btn-sm mx-1 emp-del-btn" value="'+ data +'"><img src="images/trash.svg"></button>';
                }
            }
        ],
        initComplete: function () {
            var api = this.api();

            // For each column
            api
                .columns()
                .eq(0)
                .each(function (colIdx) {
                    // Set the header cell to contain the input element
                    var cell = $('.filters th').eq(
                        $(api.column(colIdx).header()).index()
                    );
                    var title = $(cell).text();
                    $(cell).html('<input type="text" placeholder="' + title + '" />');

                    // On every keypress in this input
                    $(
                        'input',
                        $('.filters th').eq($(api.column(colIdx).header()).index())
                    )
                        .off('keyup change')
                        .on('change', function (e) {
                            // Get the search value
                            $(this).attr('title', $(this).val());
                            var regexr = '({search})'; //$(this).parents('th').find('select').val();

                            var cursorPosition = this.selectionStart;
                            // Search the column for that value
                            api
                                .column(colIdx)
                                .search(
                                    this.value != ''
                                        ? regexr.replace('{search}', '(((' + this.value + ')))')
                                        : '',
                                    this.value != '',
                                    this.value == ''
                                )
                                .draw();
                        })
                        .on('keyup', function (e) {
                            e.stopPropagation();

                            $(this).trigger('change');
                            $(this)
                                .focus()[0]
                                .setSelectionRange(cursorPosition, cursorPosition);
                        });
                });
        }
    });

    loadEmployeeTableData();

    $('#emp-form').submit(function(e){
        var btnAction = $('#emp-submit-btn').data('btn-action');
        var url;
        if (btnAction == 'add') {
            url = 'http://localhost:8080/employee/add';
        } else if (btnAction == 'edit') {
            url = 'http://localhost:8080/employee/update';
        }
        e.preventDefault();
        var reqObj = {
            "employee": {}
        };
        reqObj.employee = constructEmployeeObj();
        $.ajax({
            type: 'POST',
            url: url,
            data: JSON.stringify(reqObj),
            dataType: 'json',
            contentType: 'application/json',
            success:function(data){
                $('#employeeModal').modal('hide');
                loadEmployeeTableData();
            },
            error: function(data){
                console.log('error: ' + JSON.stringify(data));
                alert('Failed to add/update!');
            }
        });
    });

    $(document).on('click', '#emp-add-btn', function(e) {
        setSubmitBtnAction('add');
        $('#employeeModal').modal('show');
    });

    $(document).on('click', '.emp-view-btn', function(e) {
        setSubmitBtnAction('view');
        var empId = $(this).val();
        var getEmpUrl = 'http://localhost:8080/employee/get?empId='+empId;
        $.ajax({
            url: getEmpUrl,
            type: 'GET',
            contentType: 'application/json',
            dataType: 'json',
            success: function (data) {
                if (Array.isArray(data.employeeList) && data.employeeList[0]) {
                    populateEmployeeForm(data.employeeList[0]);
                    $('#empId').attr('disabled', true);
                    $('#employeeModal').modal('show');
                } else {
                    alert("Failed to load data!");
                }
            },
            error: function (data) {
                console.log('error: ' + JSON.stringify(data));
                alert('Failed to load data!');
            }
        });
    });

    $(document).on('click', '.emp-edit-btn', function(e) {
        setSubmitBtnAction('edit');
        var empId = $(this).val();
        var getEmpUrl = 'http://localhost:8080/employee/get?empId='+empId;
        $.ajax({
            url: getEmpUrl,
            type: 'GET',
            contentType: 'application/json',
            dataType: 'json',
            success: function (data) {
                if (Array.isArray(data.employeeList) && data.employeeList[0]) {
                    populateEmployeeForm(data.employeeList[0]);
                    $('#empId').attr('disabled', true);
                    $('#employeeModal').modal('show');
                } else {
                    alert("Failed to load data!");
                }
            },
            error: function (data) {
                console.log('error: ' + JSON.stringify(data));
                alert('Failed to load data!');
            }
        });
    });

    $(document).on('click', '.emp-del-btn', function(e) {
        var empId = $(this).val();
        $('#emp-conf-del-btn').val(empId);
        $('#deleteConfirmEmpId').text(empId);
        $('#deleteConfirmModal').modal('show');
    });

    $(document).on('click', '#emp-conf-del-btn', function(e) {
        var empId = $(this).val();
        var deleteEmpUrl = 'http://localhost:8080/employee/delete?empId='+empId;
        $.ajax({
            url: deleteEmpUrl,
            type: 'GET',
            contentType: 'application/json',
            dataType: 'json',
            success: function (data) {
                loadEmployeeTableData();
            },
            error: function (data) {
                console.log('error: ' + JSON.stringify(data));
                alert('Failed to delete!');
            }
        });
        $('#deleteConfirmModal').modal('hide');
    });

    $('#deleteConfirmModal').on('hidden.bs.modal', function () {
        $('#emp-conf-del-btn').val('');
        $('#deleteConfirmEmpId').text('');
    });

    $('#employeeModal').on('hidden.bs.modal', function () {
        $("#emp-form").trigger('reset');
        $('#empId').removeAttr('disabled');
    });

});