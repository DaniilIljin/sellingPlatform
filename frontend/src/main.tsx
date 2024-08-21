import { ThemeProvider } from "@emotion/react";
import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import StorePage from "./pages/example/StorePage.tsx";
import ErrorPage from "./pages/root/ErrorPage.tsx";
import Root from "./pages/root/Root.tsx";
import { theme } from "./theme.ts";
import Shop from "./pages/shop/Shop.tsx";
const router = createBrowserRouter([
    {
        path: "/",
        element: <Root />,
        errorElement: <ErrorPage />,
        children: [
            {
                path: "shop",
                element: <Shop/>
            }
        ],
    },
    {
        path: "/example",
        element: <StorePage />,
    },
]);

createRoot(document.getElementById("root")!).render(
    <StrictMode>
        <ThemeProvider theme={theme}>
            <RouterProvider router={router}></RouterProvider>
        </ThemeProvider>
    </StrictMode>
);
