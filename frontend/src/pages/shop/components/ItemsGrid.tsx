import {
    Grid,
    Card,
    CardMedia,
    CardContent,
    Typography,
    Box,
    IconButton,
} from "@mui/material";
import useFetchItems from "../hooks/useFetchItems";
import ItemCard from "./ItemCard";

const ItemsGrid = () => {
    const { items } = useFetchItems();

    return (
        <>
            {items.length !== 0 ? (
                <Grid container spacing={2}>
                    {items.map((item) => (
                        <Grid item xs={12} sm={6} md={4} key={item.id}>
                            <ItemCard item={item} />
                        </Grid>
                    ))}
                </Grid>
            ) : (
                <Typography>No data available</Typography>
            )}
        </>
    );
};

export default ItemsGrid;
