import { Box, Button, MenuItem, TextField } from "@mui/material";
import { Field, Formik } from "formik";
import * as yup from "yup";
import useMediaQuery from "@mui/material/useMediaQuery";
import Header from "../../components/Header";
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";

const userSchema = yup.object().shape({
  status: yup.string().required("Status is required"),
  startTime: yup.date().required("Start Time is required"),
  endTime: yup.date().required("End Time is required"),
  roomNumber: yup.string().required("Room Number is required"),
});

const Form = () => {
  const isNonMobile = useMediaQuery("(min-width:600px)");

  let { appointmentId } = useParams();
  appointmentId = parseInt(appointmentId);

  const navigate = useNavigate();

  const APPOINTMENT_API_BASE_URL = "https://localhost:7142/api/Appointment/";
  const [loadingAppointment, setLoadingAppointment] = useState(true);
  const [initialValues, setInitailValues] = useState(null);

  const ROOM_API_BASE_URL = "https://localhost:7142/api/Room";
  const [rooms, setRooms] = useState(null);
  const [loadingRooms, setLoadingRooms] = useState(true);

  const stausOptions = [
    { value: "AVAILABLE", label: "AVAILABLE" },
    { value: "CANCELLED", label: "CANCELLED" },
    { value: "BOOKED", label: "BOOKED" },
  ];

  useEffect(() => {
    const fetchData = async () => {
      setLoadingAppointment(true);
      try {
        const response = await fetch(APPOINTMENT_API_BASE_URL + appointmentId, {
          method: "GET",
          headers: {
            "Content-Type": "application/json",
          },
        });
        const appointment = await response.json();
        console.log(appointment);
        setInitailValues(appointment);
      } catch (error) {
        console.log(error.response);
      }
      setLoadingAppointment(false);
    };
    fetchData();
  }, [appointmentId]);

  useEffect(() => {
    const fetchData = async () => {
      setLoadingRooms(true);
      try {
        const response = await fetch(ROOM_API_BASE_URL, {
          method: "GET",
          headers: {
            "Content-Type": "application/json",
          },
        });
        const rooms = await response.json();
        console.log(rooms);
        setRooms(rooms);
      } catch (error) {
        console.log(error);
      }
      setLoadingRooms(false);
    };
    fetchData();
  }, []);

  const handleFormSubmit = async (values) => {
    const response = await fetch(APPOINTMENT_API_BASE_URL + appointmentId, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(values),
    });
    if (!response.ok) {
      throw new Error("Something went wrong");
    }
    const _appointment = await response.json();
    console.log(_appointment);
    navigate(-1);
  };

  return (
    !loadingAppointment && (
      <Box m="20px">
        <Header title="UPDATE APPOINTMENT" subTitle="Update Appointment" />
        <Formik
          onSubmit={handleFormSubmit}
          initialValues={initialValues}
          validationSchema={userSchema}
        >
          {({
            values,
            errors,
            touched,
            handleBlur,
            handleChange,
            handleSubmit,
          }) => (
            <form onSubmit={handleSubmit}>
              <Box
                display="grid"
                gap="30px"
                gridTemplateColumns="repeat(4, minmax(0, 1fr))"
                sx={{
                  "& > div": { gridColumn: isNonMobile ? undefined : "span 4" },
                }}
              >
                <TextField
                  fullWidth
                  variant="filled"
                  type="datetime-local"
                  label="Start Time"
                  onBlur={handleBlur}
                  onChange={handleChange}
                  value={values.startTime}
                  name="startTime"
                  error={!!touched.startTime && !!errors.startTime}
                  helperText={touched.startTime && errors.startTime}
                  sx={{ gridColumn: "span 2" }}
                />
                <TextField
                  fullWidth
                  variant="filled"
                  type="datetime-local"
                  label="End Time"
                  onBlur={handleBlur}
                  onChange={handleChange}
                  value={values.endTime}
                  name="endTime"
                  error={!!touched.endTime && !!errors.endTime}
                  helperText={touched.endTime && errors.endTime}
                  sx={{ gridColumn: "span 2" }}
                />
                <Field
                  fullWidth
                  variant="filled"
                  select
                  as={TextField}
                  label="Status"
                  onBlur={handleBlur}
                  onChange={handleChange}
                  name="status"
                  error={!!touched.status && !!errors.status}
                  helperText={touched.status && errors.status}
                  sx={{ gridColumn: "span 4" }}
                >
                  {stausOptions.map((option) => (
                    <MenuItem key={option.value} value={option.value}>
                      {option.label}
                    </MenuItem>
                  ))}
                </Field>
                <Field
                  fullWidth
                  variant="filled"
                  select
                  as={TextField}
                  label="Room Number"
                  onBlur={handleBlur}
                  onChange={handleChange}
                  name="roomNumber"
                  error={!!touched.roomNumber && !!errors.roomNumber}
                  helperText={touched.roomNumber && errors.roomNumber}
                  sx={{ gridColumn: "span 4" }}
                >
                  {!loadingRooms ? rooms.map((option) => (
                    <MenuItem key={option.roomId} value={option.roomNumber}>
                      {option.roomNumber}
                    </MenuItem>
                  )) : <p>Loading...</p>}
                </Field>
              </Box>
              <Box display="flex" justifyContent="end" mt="20px">
                <Button
                  onClick={() => navigate(-1)}
                  color="error"
                  variant="contained"
                  sx={{ mr: "10px" }}
                >
                  CANCEL
                </Button>
                <Button type="submit" color="secondary" variant="contained">
                  UPDATE APPOINTMENT
                </Button>
              </Box>
            </form>
          )}
        </Formik>
      </Box>
    )
  );
};

export default Form;
