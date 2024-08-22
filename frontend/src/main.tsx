import { ThemeProvider } from "@emotion/react";
import { StrictMode, useContext } from "react";
import { createRoot } from "react-dom/client";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import StorePage from "./pages/example/StorePage.tsx";
import ErrorPage from "./pages/root/ErrorPage.tsx";
import Root from "./pages/root/Root.tsx";
import { theme1, theme2 } from "./theme.ts";
import Shop from "./pages/shop/Shop.tsx";
import ViewItem from "./pages/item/ViewItem.tsx";

const router = createBrowserRouter([
    {
        path: "/",
        element: <Root />,
        errorElement: <ErrorPage />,
        children: [
            {
                path: "shop",
                element: <Shop />,
            },
            {
                path: "viewItem/:id",
                element: <ViewItem />,
            },
        ],
    },
    {
        path: "/example",
        element: <StorePage />,
    },
]);

createRoot(document.getElementById("root")!).render(
    <StrictMode>
        <ThemeProvider theme={theme1}>
            <RouterProvider router={router}></RouterProvider>
        </ThemeProvider>
    </StrictMode>
);
function createContext<T>(undefined: undefined) {
    throw new Error("Function not implemented.");
}
function useState<T>(arg0: string): [any, any] {
    throw new Error("Function not implemented.");
}

