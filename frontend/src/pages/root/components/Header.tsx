import {
    AppBar,
    Toolbar,
    Typography,
    Button,
    Box,
    Switch,
    Link,
} from "@mui/material";
import { Link as RouterLink } from "react-router-dom";

type Props = {
    themeMode: boolean,
    toggleThemeMode: () => void
}

const Header = (props: Props) => {
    return (
        <AppBar elevation={5}
            position="static"
            sx={{
                borderRadius: 1, // This applies the border-radius
                overflow: "hidden", // Ensures content doesn't overflow the rounded corners
            }}
        >
            <Toolbar>
                <Typography variant="h6" sx={{ flexGrow: 1 }}>
                    <Link
                        component={RouterLink}
                        color="inherit"
                        underline="none"
                        to={"/shop"}
                    >
                        OKi-huyoki
                    </Link>
                </Typography>
                <Button color="inherit">profile</Button>
                <Box
                    sx={{
                        display: "flex",
                        alignItems: "center",
                    }}
                >
                    <Switch
                        checked={props.themeMode}
                        onChange={props.toggleThemeMode}
                        color="primary"
                    />
                </Box>
            </Toolbar>
        </AppBar>
    );
};

export default Header;
