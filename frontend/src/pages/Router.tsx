import { Route, Routes } from "react-router-dom";
import App from "./App.tsx";
import Login from "./Login.tsx";

function Router() {
    return (
        <>
            <Routes>
                <Route path="login" element={<Login />} />
                <Route path="/" element={<App />} />
            </Routes>
        </>
    );
}

export default Router;