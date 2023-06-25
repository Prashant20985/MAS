import { Box, Button, Typography, useTheme } from "@mui/material";
import { DataGrid, GridToolbar } from "@mui/x-data-grid";
import { tokens } from "../../theme";
import Header from "../../components/Header";
import { useEffect } from "react";
import { useState } from "react";
import ArrowForwardIosIcon from "@mui/icons-material/ArrowForwardIos";
import { useNavigate } from "react-router-dom";

const DoctorsList = () => {
  const theme = useTheme();
  const colors = tokens(theme.palette.mode);
  const DOCTORS_API_BASE_URL = "https://localhost:7142/api/Doctor";
  const [loading, setLoading] = useState(true);
  const [doctors, setDoctors] = useState(null);
  const navigate = useNavigate();

  useEffect(() => {
    const fetchData = async () => {
      setLoading(true);
      try {
        const response = await fetch(DOCTORS_API_BASE_URL, {
          method: "GET",
          headers: {
            "Content-Type": "application/json",
          },
        });
        const doctors = await response.json();
        console.log(doctors);
        setDoctors(doctors);
      } catch (error) {
        console.log(error);
      }
      setLoading(false);
    };
    fetchData();
  }, []);

  const handleEvent = (doctorId) => {
    navigate(`/appointments/${doctorId}`);
  };

  const columns = [
    {
      field: "doctorId",
      minWidth: 100,
      headerName: "Docotor ID",
    },
    {
      field: "firstName",
      headerName: "Name",
      flex: 1,
      minWidth: 100,
      cellClassName: "name-column--cell",
    },
    {
      field: "lastName",
      headerName: "Surname",
      flex: 1,
      minWidth: 100,
      cellClassName: "name-column--cell",
    },
    {
      field: "ratePerHour",
      headerName: "Rate Per Hour",
      type: "number",
      headerAlign: "left",
      flex: 1,
      minWidth: 100,
      align: "left",
    },
    {
      field: "age",
      headerName: "Age",
      type: "number",
      headerAlign: "left",
      flex: 1,
      minWidth: 100,
      align: "left",
    },
    {
      field: "salary",
      headerName: "Salary",
      flex: 1,
    },
    {
      field: "specialization",
      headerName: "Specialization",
      flex: 1,
    },
    {
      headerName: "View Appointments",
      minWidth: 200,
      headerAlign: "center",
      flex: 1,
      renderCell: ({ row: { doctorId } }) => {
        return (
          <Button sx={{ width: "100%" }} onClick={() => handleEvent(doctorId)}>
            <Box
              width="70%"
              m="0 auto"
              p="5px"
              display="flex"
              justifyContent="center"
              backgroundColor={colors.greenAccent[600]}
              borderRadius="4px"
            >
              <Typography color={colors.grey[100]} sx={{ ml: "5px" }}>
                View
              </Typography>
              <ArrowForwardIosIcon sx={{ ml: "20px", height: "20px" }} />
            </Box>
          </Button>
        );
      },
    },
  ];

  return (
    <Box m="20px">
      <Header title="DOCTORS" subTitle="List of Doctors" />
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
        {!loading && (
          <DataGrid
            rows={doctors}
            columns={columns}
            getRowId={(row) => row.doctorId}
            components={{ Toolbar: GridToolbar }}
          />
        )}
      </Box>
    </Box>
  );
};

export default DoctorsList;
