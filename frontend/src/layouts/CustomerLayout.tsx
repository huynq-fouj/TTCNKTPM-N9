import { Outlet } from "react-router-dom";
import Footer from "./customer/Footer";
import Header from "./customer/Header";

export default function CustomerLayout() {



    return (
        <>
            <Header/>
                <Outlet/>
            <Footer/>
        </>
    )
}