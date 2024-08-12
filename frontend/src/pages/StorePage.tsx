import { useState } from 'react';
import { createTheme, ThemeProvider, CssBaseline, Container, Grid, Paper, Typography, Accordion, AccordionSummary, AccordionDetails, Box, Card, CardContent, CardMedia, IconButton, TextField, Divider, Switch, SpeedDial, SpeedDialAction, SpeedDialIcon } from '@mui/material';
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';
import PersonIcon from '@mui/icons-material/Person';
import FavoriteIcon from '@mui/icons-material/Favorite';
import SearchIcon from '@mui/icons-material/Search';
import MailOutlineIcon from '@mui/icons-material/MailOutline';
import MonetizationOnIcon from '@mui/icons-material/MonetizationOn';

// Define themes
const darkTheme = createTheme({
  palette: {
    mode: 'dark',
    background: {
      default: '#121212', // Background for the body
      paper: '#1e1e1e', // Background for Paper components
    },
    text: {
      primary: '#e0e0e0',
      secondary: '#b0b0b0',
    },
    primary: {
      main: '#bb86fc',
    },
    secondary: {
      main: '#03dac6',
    },
  },
});

const lightTheme = createTheme({
  palette: {
    mode: 'light',
    background: {
      default: '#f5f5f5', // Background for the body
      paper: '#ffffff', // Background for Paper components
    },
    text: {
      primary: '#000000',
      secondary: '#555555',
    },
    primary: {
      main: '#1976d2',
    },
    secondary: {
      main: '#dc004e',
    },
  },
});

const categories = [
  { name: 'Electronics', subCategories: ['Phones', 'Laptops', 'Cameras'] },
  { name: 'Fashion', subCategories: ['Men', 'Women', 'Kids'] },
  { name: 'Home & Kitchen', subCategories: ['Furniture', 'Appliances', 'Decor'] },
];

const items = [
  { id: 1, title: 'Smartphone', price: '$699', imageUrl: 'https://images.unsplash.com/photo-1507955987999-df4864ee80d4?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Nnx8cGhvbmV8ZW58MHx8MHx8fDA%3D' },
  { id: 2, title: 'Laptop', price: '$999', imageUrl: 'https://images.unsplash.com/photo-1496181133206-80ce9b88a853?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8bGFwdG9wfGVufDB8fDB8fHww' },
  { id: 3, title: 'Headphones', price: '$199', imageUrl: 'https://images.unsplash.com/photo-1577174881658-0f30ed549adc?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTR8fGhlYWRwaG9uZXN8ZW58MHx8MHx8fDA%3D' },
  { id: 4, title: 'Smartwatch', price: '$249', imageUrl: 'https://images.unsplash.com/photo-1523475496153-3d6cc0f0bf19?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8c21hcnR3YXRjaHxlbnwwfHwwfHx8MA%3D%3D' },
  { id: 5, title: 'Camera', price: '$499', imageUrl: 'https://images.unsplash.com/photo-1460134846237-51c777df6111?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8Y2FtZXJhfGVufDB8fDB8fHww' },
  { id: 6, title: 'Tablet', price: '$399', imageUrl: 'https://images.unsplash.com/photo-1471279136892-55af5dc6895f?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTB8fHRhYmxldHxlbnwwfHwwfHx8MA%3D%3D' },
  { id: 7, title: 'Bluetooth Speaker', price: '$89', imageUrl: 'https://images.unsplash.com/photo-1517756548657-b2c24162e63d?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTJ8fHNwZWFrZXJ8ZW58MHx8MHx8fDA%3D' },
  { id: 8, title: 'Drone', price: '$799', imageUrl: 'https://images.unsplash.com/photo-1473968512647-3e447244af8f?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8ZHJvbmV8ZW58MHx8MHx8fDA%3D' },
  { id: 9, title: 'Game Console', price: '$349', imageUrl: 'https://images.unsplash.com/photo-1621259181233-aa03cf592ea7?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8eGJveCUyMDM2MHxlbnwwfHwwfHx8MA%3D%3D' },
  { id: 10, title: 'Keyboard', price: '$129', imageUrl: 'https://images.unsplash.com/photo-1524578471438-cdd96d68d82c?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OHx8a2V5Ym9hcmR8ZW58MHx8MHx8fDA%3D' },
  { id: 11, title: 'Mouse', price: '$59', imageUrl: 'https://images.unsplash.com/photo-1527864550417-7fd91fc51a46?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTR8fG1vdXNlfGVufDB8fDB8fHww' },
  { id: 12, title: 'Printer', price: '$199', imageUrl: 'https://images.unsplash.com/photo-1708793699492-5fa208f52dcb?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8N3x8cHJpbnRlcnxlbnwwfHwwfHx8MA%3D%3D' },
];

const actions = [
  { icon: <MailOutlineIcon />, name: 'Contact us', action: () => window.location.href = 'mailto:support@example.com' },
  { icon: <MonetizationOnIcon/>, name: 'Support us', action: () => window.open('https://chat.example.com', '_blank') },
];

const StorePage = () => {
  const [isDarkMode, setIsDarkMode] = useState<boolean>(true);
  const [open, setOpen] = useState<boolean>(false);

  const toggleTheme = () => {
    setIsDarkMode(prevMode => !prevMode);
  };

  const theme = isDarkMode ? darkTheme : lightTheme;

  return (
    <ThemeProvider theme={theme}>
      <CssBaseline /> {/* Apply baseline styles */}
      <Container component="main" maxWidth="lg" sx={{ display: 'flex', justifyContent: 'center', mt: 4, bgcolor: 'background.default', minHeight: '100vh' }}>
        <Grid container spacing={2}>
          {/* Left Sidebar */}
          <Grid item xs={12} md={3}>
            <Paper sx={{ padding: 2, bgcolor: 'background.paper' }}>
              {/* Theme Toggle */}
              <Box sx={{ display: 'flex', alignItems: 'center'}}>
                <Typography variant="body2" sx={{ mr: 1 }}>{isDarkMode ? "dark" : "light"}</Typography>
                <Switch checked={isDarkMode} onChange={toggleTheme} color="primary" />
              </Box>
              <Divider/>


              {/* Profile and Search Bar */}
              <Box sx={{ display: 'flex', alignItems: 'center', mb: 1 }}>
                  <IconButton color="primary" aria-label="edit profile" sx={{ p: 1 }}>
                    <PersonIcon />
                  </IconButton>
                  <Typography variant="body2" sx={{ ml: 1 }}>Edit Profile</Typography>
                </Box>
                <Box sx={{ display: 'flex', alignItems: 'center', mb: 1 }}>
                  <IconButton color="primary" aria-label="liked items" sx={{ p: 1 }}>
                    <FavoriteIcon />
                  </IconButton>
                  <Typography variant="body2" sx={{ ml: 1 }}>Liked Items</Typography>
                </Box> 
                <Divider/>
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
                    sx={{ '& .MuiInputBase-root': { height: 40 } }}
                  />
                </Box>
                <Divider/>

              {/* Categories */}
              <Typography variant="h6" sx={{ mb: 1 }}>Categories</Typography>
              {categories.map((category, index) => (
                <Accordion key={index} sx={{ mb: 1 }}>
                  <AccordionSummary expandIcon={<ExpandMoreIcon />}>
                    <Typography variant="body1">{category.name}</Typography>
                  </AccordionSummary>
                  <AccordionDetails sx={{ maxHeight: 100, overflowY: 'auto' }}>
                    {category.subCategories.map((sub, subIndex) => (
                      <Typography key={subIndex} variant="body2" sx={{ mb: 0.5 }}>
                        {sub}
                      </Typography>
                    ))}
                  </AccordionDetails>
                </Accordion>
              ))}
            </Paper>
          </Grid>
          {/* Main Content */}
          <Grid item xs={12} md={9}>
            <Grid container spacing={2}>
              {items.map((item) => (
                <Grid item xs={12} sm={6} md={4} key={item.id}>
                  <Card>
                    <CardMedia
                      component="img"
                      height="160"
                      image={item.imageUrl}
                      alt={item.title}
                    />
                    <CardContent>
                      <Typography gutterBottom variant="h6" component="div">
                        {item.title}
                      </Typography>
                      <Typography variant="body2" color="text.secondary">
                        {item.price}
                      </Typography>
                    </CardContent>
                    <Box sx={{ display: 'flex', justifyContent: 'flex-end', p: 1 }}>
                      <IconButton color="primary">
                        <ShoppingCartIcon />
                      </IconButton>
                    </Box>
                  </Card>
                </Grid>
              ))}
            </Grid>
          </Grid>
        </Grid>
      </Container>
      {/* Speed Dial for Contact Options */}
      <SpeedDial
        ariaLabel="Contact Support"
        sx={{ position: 'fixed', bottom: 16, right: 16 }}
        icon={<SpeedDialIcon />}
        onOpen={() => setOpen(true)}
        onClose={() => setOpen(false)}
        open={open}
      >
        {actions.map((action) => (
          <SpeedDialAction
            key={action.name}
            icon={action.icon}
            tooltipTitle={action.name}
            onClick={action.action}
          />
        ))}
      </SpeedDial>
    </ThemeProvider>
  );
};

export default StorePage;
