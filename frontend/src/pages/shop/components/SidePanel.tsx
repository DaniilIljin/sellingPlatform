import FavoriteIcon from "@mui/icons-material/Favorite";
import SearchIcon from "@mui/icons-material/Search";
import {
    Box,
    Button,
    IconButton,
    Paper,
    TextField,
    Typography,
} from "@mui/material";
import useFetchCategories from "../hooks/useFetchCategories";
import CategoryAccordion from "./CategoryAccordion";

const SidePanel = () => {
    const { categories } = useFetchCategories();

    // const categories = [
    //     { name: "Electronics", subCategories: ["Phones", "Laptops", "Cameras"] },
    //     { name: "Fashion", subCategories: ["Men", "Women", "Kids"] },
    //     {
    //         name: "Home & Kitchen",
    //         subCategories: ["Furniture", "Appliances", "Decor"],
    //     },
    // ];

    return (
        <>
            <Paper elevation={5} sx={{ padding: 2, bgcolor: "background.paper" }}>
                <Box
                    sx={{
                        display: "flex",
                        alignItems: "center",
                        justifyContent: "center",
                        mb: 1,
                    }}
                >
                    <Button
                        fullWidth={true}
                        color="primary"
                        aria-label="liked items"
                    >
                        <FavoriteIcon />
                        <Typography variant="body2">Liked Items</Typography>
                    </Button>
                </Box>
                <Box sx={{ mb: 1 }}>
                    <TextField
                        fullWidth
                        variant="outlined"
                        size="small"
                        placeholder="Search..."
                        InputProps={{
                            endAdornment: (
                                <IconButton edge="end" >
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
            </Paper>
        </>
    );
};

export default SidePanel;
