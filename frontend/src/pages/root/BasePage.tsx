import { Container, ThemeProvider } from "@mui/material";
import Background from "./components/Background";
import Header from "./components/Header";
import React, { useState } from "react";
import { theme1, theme2 } from "./theme";

type BasePageProps = {
    children?: React.ReactNode;
};

const BasePage: React.FC<BasePageProps> = ({ children }) => {
    const [themeMode, setThemeMode] = useState(false);

    const toggleThemeMode = () => {
        console.log(`Current mode: ${themeMode ? "dark" : "light"}`); // Debugging: Check current mode
        setThemeMode(prevMode => {
          const newMode = !prevMode;
          return newMode;
      });
    };

    return (
        <>
            <ThemeProvider theme={themeMode ? theme1 : theme2}>
                <Background />
                <Container>
                    <Header
                        themeMode={themeMode}
                        toggleThemeMode={toggleThemeMode}
                    />
                    {children}
                </Container>
            </ThemeProvider>
        </>
    );
};

export default BasePage;
