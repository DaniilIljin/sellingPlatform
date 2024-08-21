import { Grid } from "@mui/material";
import ItemsGrid from "./components/ItemsGrid";
import SidePanel from "./components/SidePanel";


const Shop = () => {

    return (
        <>
            <Grid container mt={1} spacing={2}>
                <Grid item xs={12} md={3}>
                    <SidePanel/>
                </Grid>
                <Grid item xs={12} md={9}>
                    <ItemsGrid/>
                </Grid>
            </Grid>
        </>
    );
};

export default Shop;
