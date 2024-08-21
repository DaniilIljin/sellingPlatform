import { Paper, Box, Button, Typography, TextField, IconButton, Accordion, AccordionSummary, AccordionDetails } from "@mui/material";
import ExpandMoreIcon from "@mui/icons-material/ExpandMore";
import FavoriteIcon from "@mui/icons-material/Favorite";
import SearchIcon from "@mui/icons-material/Search";


const SidePanel = () => {

    const categories = [
        { name: "Electronics", subCategories: ["Phones", "Laptops", "Cameras"] },
        { name: "Fashion", subCategories: ["Men", "Women", "Kids"] },
        {
            name: "Home & Kitchen",
            subCategories: ["Furniture", "Appliances", "Decor"],
        },
    ];
    
    return (
        <>
            <Paper sx={{ padding: 2, bgcolor: "background.paper" }}>
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
                                <IconButton edge="end" color="primary">
                                    <SearchIcon />
                                </IconButton>
                            ),
                        }}
                        sx={{
                            "& .MuiInputBase-root": { height: 40 },
                        }}
                    />
                </Box>

                {categories.map((category, index) => (
                    <Accordion key={index} sx={{ mb: 1 }}>
                        <AccordionSummary expandIcon={<ExpandMoreIcon />}>
                            <Typography variant="body1">
                                {category.name}
                            </Typography>
                        </AccordionSummary>
                        <AccordionDetails
                            sx={{
                                maxHeight: 100,
                                overflowY: "auto",
                            }}
                        >
                            {category.subCategories.map((sub, subIndex) => (
                                <Typography
                                    key={subIndex}
                                    variant="body2"
                                    sx={{ mb: 0.5 }}
                                >
                                    {sub}
                                </Typography>
                            ))}
                        </AccordionDetails>
                    </Accordion>
                ))}
            </Paper>
        </>
    );
};

export default SidePanel;
