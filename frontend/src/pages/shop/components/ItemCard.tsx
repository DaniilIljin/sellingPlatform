import { Card, CardMedia, CardContent, Typography, Box, IconButton } from "@mui/material";
import { Item } from "../../../dto/Item";
import FavoriteBorderIcon from "@mui/icons-material/FavoriteBorder";
import ShoppingCartIcon from "@mui/icons-material/ShoppingCart";

type Props = {
    item: Item
}

const ItemCard = (props: Props) => {
    return (
        <>
            <Card>
                <CardMedia
                    component="img"
                    height="160"
                    // image={item.imageUrl}
                    // alt={item.title}
                />
                <CardContent>
                    <Typography gutterBottom variant="h6" component="div">
                        {props.item.name}
                    </Typography>
                    <Typography variant="body2" color="text.secondary">
                        {props.item.categoryName}
                    </Typography>
                </CardContent>
                <Box
                    sx={{
                        display: "flex",
                        justifyContent: "space-between",
                        p: 1,
                    }}
                >
                    <IconButton color="primary">
                        <FavoriteBorderIcon />
                    </IconButton>
                    <IconButton color="primary">
                        <ShoppingCartIcon />
                    </IconButton>
                </Box>
            </Card>
        </>
    );
};

export default ItemCard;
