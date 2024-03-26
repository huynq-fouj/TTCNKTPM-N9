import { useEffect, useState } from "react"
import StorageService from "../../shared/services/StorageService";
import MemberDetails from "./components/MemberDetails";
import AuthForm from "./components/auth/AuthForm";

export default function Member() {

    const [isLoggedIn, setIsLoggedIn] = useState<boolean>(false);

    useEffect(() => {
        setIsLoggedIn(StorageService.isLoggedIn());
    }, []);

    return (
        <>
            {isLoggedIn ? <MemberDetails/> : <AuthForm/>}
        </>
    )
}