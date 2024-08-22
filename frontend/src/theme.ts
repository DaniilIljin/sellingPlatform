import { createTheme } from "@mui/material";

export const theme1 = createTheme({
    palette: {
        mode: "dark",
        background: {
            default: "#121212",
            paper: "#1e1e1e",
        },
        text: {
            primary: "#e0e0e0",
            secondary: "#b0b0b0",
        },
        primary: {
            main: "#bb86fc",
        },
        secondary: {
            main: "#03dac6",
        },
    },
});


export const theme2 = createTheme({
  palette: {
    mode: 'light', // Ensure this is set to 'light'
    primary: {
      main: '#1976d2', // Primary color
    },
    secondary: {
      main: '#dc004e', // Secondary color
    },
    background: {
      default: '#f5f5f5', // Background color
      paper: '#ffffff', // Paper color
    },
    text: {
      primary: '#000000', // Primary text color
      secondary: '#555555', // Secondary text color
    },
  },
  typography: {
    fontFamily: '"Roboto", "Helvetica", "Arial", sans-serif',
    h1: {
      fontSize: '2.5rem',
    },
    h2: {
      fontSize: '2rem',
    },
    h3: {
      fontSize: '1.75rem',
    },
    h4: {
      fontSize: '1.5rem',
    },
    h5: {
      fontSize: '1.25rem',
    },
    h6: {
      fontSize: '1rem',
    },
    body1: {
      fontSize: '1rem',
    },
    body2: {
      fontSize: '0.875rem',
    },
  },
});
