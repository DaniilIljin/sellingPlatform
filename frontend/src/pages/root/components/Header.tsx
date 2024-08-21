import { AppBar, Toolbar, Typography, Button, Box, Switch } from "@mui/material";
import { Link } from "react-router-dom";

const Header = () => {
    return (
        <AppBar position="static">
            <Toolbar>
                <Typography variant="h6" sx={{ flexGrow: 1 }}>
                    <Link to={"/shop"}>OKi-huyoki</Link>
                </Typography>
                <Button color="inherit">profile</Button>
                <Box
                    sx={{
                        display: "flex",
                        alignItems: "center",
                    }}
                >

                    <Switch
                        // checked={isDarkMode}
                        // onChange={toggleTheme}
                        color="primary"
                    />
                </Box>
            </Toolbar>
        </AppBar>
    );
};

export default Header;
