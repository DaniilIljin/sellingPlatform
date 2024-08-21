import { Outlet } from "react-router-dom";
import BasePage from "./BasePage";

const Root = () => {
    return (
        <BasePage>
            <Outlet />
        </BasePage>
    );
};

export default Root;
