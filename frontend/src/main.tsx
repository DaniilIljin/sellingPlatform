import { StrictMode} from "react";
import { createRoot } from "react-dom/client";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import StorePage from "./pages/example/StorePage.tsx";
import ViewItem from "./pages/item/ViewItem.tsx";
import ErrorPage from "./pages/root/ErrorPage.tsx";
import Root from "./pages/root/Root.tsx";
import Shop from "./pages/shop/Shop.tsx";
import AddItem from "./pages/item/AddItem.tsx";
import Test from "./pages/example/Test.tsx";

const router = createBrowserRouter([
    {
        path: "/",
        element: <Root />,
        errorElement: <ErrorPage />,
        children: [
            {
                path: "/",
                element: <Shop />,
            },
            {
                path: "viewItem/:id",
                element: <ViewItem />,
            },
            {
                path: "addItem",
                element: <AddItem />,
            },
        ],
    },
    {
        path: "/example",
        element: <StorePage />,
    },
    {
        path: "/test",
        element:   <Test />,
    },
]);

createRoot(document.getElementById("root")!).render(
    <StrictMode>
            <RouterProvider router={router}></RouterProvider>
    </StrictMode>
);