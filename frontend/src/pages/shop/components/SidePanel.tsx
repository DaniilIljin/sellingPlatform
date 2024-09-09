import AddIcon from "@mui/icons-material/Add";
import FavoriteIcon from "@mui/icons-material/Favorite";
import FolderIcon from "@mui/icons-material/Folder";
import SearchIcon from "@mui/icons-material/Search";
import {
    Box,
    ButtonGroup,
    Divider,
    IconButton,
    Paper,
    TextField,
    Typography,
} from "@mui/material";
import { Link } from "react-router-dom";
import useFetchBrands from "../hooks/useFetchBrands";
import useFetchCategories from "../hooks/useFetchCategories";
import CategoryAccordion from "./CategoryAccordion";
import BrandAccordion from "./BrandAccordion";

const SidePanel = () => {
    const { categories } = useFetchCategories();
    const { brands } = useFetchBrands();

    return (
        <>
            <Paper
                elevation={5}
                sx={{ padding: 2, bgcolor: "background.paper" }}
            >
                <Box
                    sx={{
                        display: "flex",
                        alignItems: "center",
                        justifyContent: "center",
                        mb: 1,
                    }}
                >
                    <ButtonGroup variant="contained">
                        <IconButton>
                            <FavoriteIcon />
                        </IconButton>
                        <IconButton>
                            <FolderIcon />
                        </IconButton>
                        <IconButton component={Link} to={"addItem"}>
                            <AddIcon />
                        </IconButton>
                    </ButtonGroup>
                </Box>
                <Box sx={{ mb: 1 }}>
                    <TextField
                        fullWidth
                        variant="outlined"
                        size="small"
                        placeholder="Search..."
                        InputProps={{
                            endAdornment: (
                                <IconButton edge="end">
                                    <SearchIcon />
                                </IconButton>
                            ),
                        }}
                        sx={{
                            "& .MuiInputBase-root": { height: 40 },
                        }}
                    />
                </Box>
                <Box
                    sx={{
                        cursor: "pointer",
                        fontSize: "16px",
                    }}
                >
                    <Typography>All</Typography>
                </Box>

                {categories.map((category, index) => (
                    <CategoryAccordion key={index} category={category} />
                ))}
                <Divider />
                {brands.map((brand, index) => (
                    <BrandAccordion key={index} brand={brand} />
                ))}
            </Paper>
        </>
    );
};

export default SidePanel;
