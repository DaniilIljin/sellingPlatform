import { createTheme } from "@mui/material";

export const theme = createTheme({
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
