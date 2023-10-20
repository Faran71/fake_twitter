import MainPage from "./MainPage";
import { BrowserRouter, Routes, Route } from "react-router-dom";

const ControlPage = () => {

    return(
        <div>
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<MainPage/>} />
                    
                </Routes>
            </BrowserRouter>
        </div>

    )
}

export default ControlPage;