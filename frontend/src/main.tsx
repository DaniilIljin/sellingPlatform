import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import {QueryClientProvider} from "@tanstack/react-query";
import queryClient from "./query/queryClient.ts";
import {BrowserRouter} from "react-router-dom";
import Router from "./pages/Router.tsx";

createRoot(document.getElementById('root')!).render(
    <StrictMode>
        <QueryClientProvider client={queryClient}>
            <BrowserRouter>
                <Router/>
            </BrowserRouter>
        </QueryClientProvider>
    </StrictMode>
)
