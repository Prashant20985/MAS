import { Box, useTheme, Typography, Button } from "@mui/material";
import { tokens } from "../../theme";
import Header from "../../components/Header";
import { useEffect } from "react";
import { useState } from "react";
import { DataGrid, GridToolbar } from "@mui/x-data-grid";
import { useNavigate, useParams } from "react-router-dom";
import EditIcon from "@mui/icons-material/Edit";
import ArrowBackIosNewIcon from "@mui/icons-material/ArrowBackIosNew";

function AppointmentList() {
  let { doctorId } = useParams();
  doctorId = parseInt(doctorId);

  const navigate = useNavigate();

  const theme = useTheme();
  const colors = tokens(theme.palette.mode);

  const APPOINTMENTS_API_BASE_URL =
    "https://localhost:7142/api/Appointment/doctor/";
  const [appointments, setAppointments] = useState(null);
  const [loadingAppointment, setLoadingAppointment] = useState(true);

  const DOCTOR_API_BASE_URL = "https://localhost:7142/api/Doctor/";
  const [doctor, setDoctor] = useState(null);
  const [loadingDoctor, setLoadingDoctor] = useState(true);

  useEffect(() => {
    const fetchData = async () => {
      setLoadingDoctor(true);
      try {
        const response = await fetch(DOCTOR_API_BASE_URL + doctorId, {
          method: "GET",
          headers: {
            "Content-Type": "application/json",
          },
        });
        const doctor = await response.json();
        console.log(doctor);
        setDoctor(doctor);
      } catch (error) {
        console.log(error);
      }
      setLoadingDoctor(false);
    };
    fetchData();
  }, [doctorId]);

  useEffect(() => {
    const fetchData = async () => {
      setLoadingAppointment(true);
      try {
        const response = await fetch(APPOINTMENTS_API_BASE_URL + doctorId, {
          method: "GET",
          headers: {
            "Content-Type": "application/json",
          },
        });
        const appointments = await response.json();
        console.log(appointments);
        setAppointments(appointments);
      } catch (error) {
        console.log(error);
      }
      setLoadingAppointment(false);
    };
    fetchData();
  }, [doctorId]);

  const handleEvent = (params) => {
    navigate(`/appointments/edit/` + params);
  };

  const columns = [
    {
      field: "appointmentId",
      minWidth: 100,
      headerName: "Appointment ID",
    },
    {
      field: "startTime",
      headerName: "Start Time",
      type: "dateTime",
      valueGetter: ({ value }) => value && new Date(value),
      flex: 1,
      minWidth: 100,
    },
    {
      field: "endTime",
      headerName: "End Time",
      type: "dateTime",
      valueGetter: ({ value }) => value && new Date(value),
      flex: 1,
      minWidth: 100,
    },
    {
      field: "nurseName",
      headerName: "Nurse Name",
      flex: 1,
      cellClassName: "name-column--cell",
    },
    {
      field: "roomNumber",
      headerName: "Room Number",
      flex: 1,
      cellClassName: "name-column--cell",
    },
    {
      field: "procedureTitle",
      headerName: "Procedure Title",
      flex: 1,
      cellClassName: "name-column--cell",
    },
    {
      field: "examinationType",
      headerName: "Examination Type",
      flex: 1,
      cellClassName: "name-column--cell",
    },
    {
      field: "totalCost",
      headerName: "Cost",
      flex: 1,
      cellClassName: "name-column--cell",
    },
    {
      field: "status",
      headerName: "Status",
      headerAlign: "center",
      flex: 1,
      renderCell: ({ row: { status } }) => {
        return (
          <Box
            width="100%"
            m="0 auto"
            p="5px"
            display="flex"
            justifyContent="center"
            backgroundColor={
              status === "BOOKED"
                ? colors.greenAccent[600]
                : status === "AVAILABLE"
                ? colors.greenAccent[800]
                : colors.redAccent[700]
            }
            borderRadius="4px"
          >
            <Typography color={colors.grey[100]} sx={{ ml: "5px" }}>
              {status}
            </Typography>
          </Box>
        );
      },
    },
    {
      headerName: "EDIT",
      headerAlign: "center",
      flex: 1,
      renderCell: ({ row: { appointmentId } }) => {
        return (
          <Button
            sx={{ width: "100%" }}
            onClick={() => handleEvent(appointmentId)}
          >
            <Box
              width="100%"
              m="0 auto"
              p="5px"
              display="flex"
              justifyContent="center"
              backgroundColor={colors.blueAccent[700]}
              borderRadius="4px"
            >
              <EditIcon />
              <Typography color={colors.grey[100]} sx={{ ml: "5px" }}>
                Edit
              </Typography>
            </Box>
          </Button>
        );
      },
    },
  ];

  return (
    <Box m="20px">
      <Button
        onClick={() => navigate(-1)}
        color="info"
        variant="text"
        sx={{ mb: "10px" }}
      >
        <ArrowBackIosNewIcon />
        RETURN
      </Button>
      {!loadingDoctor && (
        <Header
          title={`Appointments for ` + doctor.firstName + " " + doctor.lastName}
          subTitle="List Of Appointments"
        />
      )}
      <Box
        m="40px 0 0 0"
        height="75vh"
        sx={{
          "& .MuiDataGrid-root": {
            border: "none",
          },
          "& .MuiDataGrid-cell": {
            borderBottom: "none",
          },
          "& .name-column--cell": {
            color: colors.greenAccent[300],
          },
          "& .MuiDataGrid-columnHeaders": {
            backgroundColor: colors.blueAccent[700],
            borderBottom: "none",
          },
          "& .MuiDataGrid-virtualScroller": {
            backgroundColor: colors.primary[400],
          },
          "& .MuiDataGrid-footerContainer": {
            borderTop: "none",
            backgroundColor: colors.blueAccent[700],
          },
          "& .MuiCheckbox-root": {
            color: `${colors.greenAccent[200]} !important`,
          },
          "& .MuiDataGrid-toolbarContainer .MuiButton-text": {
            color: `${colors.grey[100]} !important`,
          },
        }}
      >
        {!loadingAppointment && (
          <DataGrid
            rows={appointments}
            columns={columns}
            getRowId={(row) => row.appointmentId}
            components={{ Toolbar: GridToolbar }}
          />
        )}
      </Box>
    </Box>
  );
}

export default AppointmentList;
